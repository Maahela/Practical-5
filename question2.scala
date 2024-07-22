import scala.io.StdIn._

object LibraryManagementSystem {

  // Define the Book case class
  case class Book(title: String, author: String, isbn: String)

  // Initial set of books
  var library: Set[Book] = Set(
    Book("To Kill a Mockingbird", "Harper Lee", "1234567890"),
    Book("1984", "George Orwell", "1234567891"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567892")
  )

  def main(args: Array[String]): Unit = {
    var continue = true

    while (continue) {
      println("Library Management System")
      println("1. Display Library")
      println("2. Add Book")
      println("3. Remove Book")
      println("4. Check Book by ISBN")
      println("5. Search Book by Title")
      println("6. Display Books by Author")
      println("7. Exit")
      print("Choose an option: ")

      readLine() match {
        case "1" => displayLibrary()
        case "2" => addBook()
        case "3" => removeBookByIsbn()
        case "4" => checkBookByIsbn()
        case "5" => searchBookByTitle()
        case "6" => displayBooksByAuthor()
        case "7" => continue = false
        case _ => println("Invalid option. Please try again.")
      }
    }
  }

  // Function to add a new book to the library
  def addBook(): Unit = {
    println("Enter book title:")
    val title = readLine()
    println("Enter book author:")
    val author = readLine()
    println("Enter book ISBN:")
    val isbn = readLine()

    val newBook = Book(title, author, isbn)
    if (library.exists(_.isbn == isbn)) {
      println("A book with this ISBN already exists in the library.")
    } else {
      library += newBook
      println(s"Book '${title}' by ${author} added to the library.")
    }
  }

  // Function to remove a book from the library by its ISBN
  def removeBookByIsbn(): Unit = {
    println("Enter book ISBN to remove:")
    val isbn = readLine()

    val bookToRemove = library.find(_.isbn == isbn)
    bookToRemove match {
      case Some(book) =>
        library -= book
        println(s"Book '${book.title}' by ${book.author} removed from the library.")
      case None => println("No book found with the given ISBN.")
    }
  }

  // Function to check if a book is already in the library by its ISBN
  def checkBookByIsbn(): Unit = {
    println("Enter book ISBN to check:")
    val isbn = readLine()

    if (library.exists(_.isbn == isbn)) {
      println("The book is in the library.")
    } else {
      println("The book is not in the library.")
    }
  }

  // Function to display the current library collection
  def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach { book =>
      println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
    }
    println()
  }

  // Function to search for a book by its title and display its details if found
  def searchBookByTitle(): Unit = {
    println("Enter book title to search:")
    val title = readLine()

    val result = library.find(_.title == title)
    result match {
      case Some(book) => println(s"Book Found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None => println(s"No book found with title: $title")
    }
  }

  // Function to display all books by a specific author
  def displayBooksByAuthor(): Unit = {
    println("Enter author name to search:")
    val author = readLine()

    val booksByAuthor = library.filter(_.author == author)
    if (booksByAuthor.isEmpty) {
      println(s"No books found by author: $author")
    } else {
      println(s"Books by $author:")
      booksByAuthor.foreach { book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      }
    }
  }
}
