import scala.concurrent.Future
import scala.collection.mutable.Map._

class CustomerServices {

  val customer_details = scala.collection.mutable.Map(
    8587878471L -> Customer("umang.kesari@knoldus.in", "Umang", 8587878471L, "knoldus123")
  )

  def login(mobileNo: Long, password: String): Future[Boolean] = {
    Future(
      if (customer_details.contains(mobileNo)) {
        false
      }
      else {
        if (customer_details.values.map(_.password) != password )
        {
           false
        }
        else
        {
          true
        }
      }
    )
  }

  def createCustomer(newCustomer: Customer): Future[Boolean] = {
    Future(
      if (customer_details.contains(newCustomer.mobileNumber)) {
        false
      }
      else {
        customer_details += newCustomer.mobileNumber -> newCustomer
        true
      }
    )
  }
}
