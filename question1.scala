object InventoryManagementSystem {

  def main(args: Array[String]): Unit = {
    val products = getProductList()
    printProductList(products)
    println(s"Total number of products: ${getTotalProducts(products)}")
  }

  def getProductList(): List[String] = {
    import scala.io.StdIn.readLine
    var products: List[String] = List()
    var input: String = ""

    println("Enter product names (type 'done' to finish):")

    while (input != "done") {
      input = readLine()
      if (input != "done") {
        products = products :+ input
      }
    }

    products
  }

  def printProductList(products: List[String]): Unit = {
    products.zipWithIndex.foreach { case (product, index) =>
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(products: List[String]): Int = {
    products.size
  }
}
