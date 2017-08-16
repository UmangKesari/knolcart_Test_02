import scala.concurrent.Future

class ItemServices {

  val item_details = scala.collection.mutable.Map(
    ("t-shirt","men") -> ItemDetails(1,599.0,"Raju Garments","color : blue, size : 39",
      Categories("t-shirt","men"),3.5)

  )

  def searchItemByCategory(category :Categories) : Future[Option[List[ItemDetails]]] ={
    Future(
      val getItems  = item_details.get(category.parentCategory,category.childCategory).map._.toList)

    if(getItems.){
      None
    }
    else{
      getItems.toList
    }
    )
  }

  def sortByPrice(sortIn: String): Future[List[ItemDetails]] = {
    Future {
      if(sortIn.equalsIgnoreCase("price low to high")) {
      item_details.values.toList.flatten.sortBy(_.price => itemsPrice)
      }
      else if(sortIn.equalsIgnoreCase("price high to low")) {
        item_details.values.toList.flatten.sortBy(_.price =>itemsPrice).reverse
      }

    }
  }

  def sortByRatings(sortIn: String): Future[List[ItemDetails]] = {
    Future {
      if(sortIn.equalsIgnoreCase("price low to high")) {
        item_details.values.toList.flatten.sortBy(_.ratings => itemsRatings)
      }
      else if(sortIn.equalsIgnoreCase("price high to low")) {
        item_details.values.toList.flatten.sortBy(_.rating =>itemsRatings).reverse
      }

    }
  }
  def getPrice(inventory: Inventory, itemID: String): Future[ItemPrice] = Future{
    inventory.itemsList.filter(_.itemId == itemID)(-1).price
  }

}

}
