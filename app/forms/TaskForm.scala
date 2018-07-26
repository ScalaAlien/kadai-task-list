package forms

case class TaskForm(id: Option[Long], status: String, subject: String, supporter: String, content: String)