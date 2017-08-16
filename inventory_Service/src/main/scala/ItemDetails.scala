
case class ItemDetails(id : Int, price : Double, vendor : String, description : String,
                       category :Categories, rating :Double)

case class Categories(parentCategory : String, childCategory : String)