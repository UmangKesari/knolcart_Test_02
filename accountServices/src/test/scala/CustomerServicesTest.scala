import org.scalatest.AsyncFunSuite

class CustomerServicesTest extends AsyncFunSuite {

  val testCustomerService = new CustomerServices

  val testExistingCustomer =scala.collection.mutable.Map(8587878471L ->Customer("umang.kesari@knoldus.in","Umang",
                                                                8587878471L,"knoldus123"))

  val testNonExistingCustomer =scala.collection.mutable.Map(85878471L ->Customer("umang.kesari@knoldus.in","Umang",
    8587878471L,"knoldus123"))

  test("Testing log In method for existing customer") {
    testCustomerService.login(8587878471L,"knoldus123").map(validCustomer => assert(validCustomer))
  }

  test("Testing log In method for non-existing customer")
  {
    testCustomerService.login(85878781L,"knoldus123").map(validCustomer => assert(validCustomer))
  }

  test("Testing create Customer method for non_existing"){
    testCustomerService.createCustomer(testNonExistingCustomer).map(validNewCustomer => assert(validNewCustomer))
  }

  test("Testing create Customer method for existing Customer")
  {
    testCustomerService.createCustomer(testExistingCustomer).map(validNewCustomer => assert(validNewCustomer))

  }

}
