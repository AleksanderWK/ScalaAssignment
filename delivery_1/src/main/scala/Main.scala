class Task1 {

  def A(): Unit = {
    println("Task 1A")
    var nums: List[Int] = List()
    for (n <- 1 to 50){
      nums = nums :+ n
    }
    println(nums)
  }

  def sum(list: List[Int]): Int = {
    var sum: Int = 0

    for (item <- list) {
      sum += item
    }

    sum
  }
  
  def B(): Unit = {
    println("Task 1B:")
    println(sum(List(1, 2, 3)))
  }

  def recursiveSum(list: List[Int], accSum: Int): Int = list match {
    case Nil => accSum
    case head :: tail => recursiveSum(tail, accSum + head)
  } 

  def C(): Unit = {
    println("Task 1C:")
    val test: List[Int] = List(1, 2, 3)
    println(recursiveSum(test, 0))
  }

  def D(): Unit = {
    println("Task 1D:")
  }
}

class Task2() {

  def A(): Unit = {
    println("Task 2A:")
  }

  def B(): Unit = {
    println("Task 2B:")
  }

  def C(): Unit = {
    println("Task 2C:")
  }

  def D(): Unit = {
    println("Task 2D:")
  }
}


object Main extends App {
  val task1 = new Task1
  val task2 = new Task2
  task1.A()
  task1.B()
  task1.C()
  task1.D()
  task2.A()
  task2.B()
  task2.C()
  task2.D()

}