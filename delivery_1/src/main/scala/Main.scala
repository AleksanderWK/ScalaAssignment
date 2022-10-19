class Task1 {

  def A(): Unit = {
    println("Task 1A")
    var nums: List[Int] = List()
    for (n <- 1 to 50){
      nums = nums :+ n
    }
    println(nums)
  }

  def B(): Unit = {
    print("Task 1B: \n")
  }

  def recursiveSum(list: List[Int], accSum: Int): Int = list match {
    case Nil => accSum
    case head :: tail => recursiveSum(tail, accSum + head)
  } 

  def C(): Unit = {
    val test: List[Int] = List(1, 2, 3)
    println(recursiveSum(test, 0))
  }

  def D(): Unit = {
    print("Task 1D: \n")
  }
}

class Task2() {

  def A(): Unit = {
    print("Task 2A: \n")
  }

  def B(): Unit = {
    print("Task 2B: \n")
  }

  def C(): Unit = {
    print("Task 2C: \n")
  }

  def D(): Unit = {
    print("Task 2D: \n")
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