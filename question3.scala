object FibonacciSequence {

  def main(args: Array[String]): Unit = {
    println("Enter the number of Fibonacci numbers to print:")
    val n = scala.io.StdIn.readInt()
    println(s"The first $n Fibonacci numbers are:")
    printFibonacci(n)
  }

  // Recursive function to calculate the nth Fibonacci number
  def fibonacci(n: Int): Int = {
    if (n <= 1) n
    else fibonacci(n - 1) + fibonacci(n - 2)
  }

  // Function to print the first n Fibonacci numbers
  def printFibonacci(n: Int): Unit = {
    for (i <- 0 until n) {
      print(s"${fibonacci(i)} ")
    }
    println()
  }
}
