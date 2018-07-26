package forms

case class TaskForm(id: Option[Long], subject: String, supporter: String, content: String)