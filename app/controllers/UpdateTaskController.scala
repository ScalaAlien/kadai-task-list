package controllers

import java.time.ZonedDateTime
import javax.inject._

import forms.TaskForm
import models.Task
import play.api.i18n.{ I18nSupport, Messages }
import play.api.mvc._
import scalikejdbc._, jsr310._ // 手動でインポートしてください。


@Singleton
class UpdateTaskController @Inject()(components: ControllerComponents)
  extends AbstractController(components)
    with I18nSupport
    with TaskControllerSupport {

  def index(TaskId: Long): Action[AnyContent] = Action { implicit request =>
    val result = Task.findById(TaskId).get
    val filledForm = form.fill(
      TaskForm(result.id, result.subject, result.supporter, result.content))
    Ok(views.html.edit(filledForm))
  }

  // 追加
  def update: Action[AnyContent] = Action { implicit request =>
    form
      .bindFromRequest()
      .fold(
        formWithErrors => BadRequest(views.html.edit(formWithErrors)), { model =>
          implicit val session = AutoSession
          val result = Task
            .updateById(model.id.get)
            .withAttributes(
              'subject     -> model.subject,
              'supporter     -> model.supporter,
              'content     -> model.content,
              'updateAt -> ZonedDateTime.now()
            )
          if (result > 0)
            Redirect(routes.GetTasksController.index())
          else
            InternalServerError(Messages("UpdateMessageError"))
        }
      )
  }

}