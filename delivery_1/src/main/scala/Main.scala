class Task1 {

  def A(): Unit = {
    println("Task 1A:")

    var nums: List[Int] = List()

    for (n <- 1 to 50){
      nums = nums :+ n
    }

    println(nums)
  }
  
  def B(): Unit = {
    println("Task 1B:")

    def sum(list: List[Int]): Int = {
      var sum: Int = 0

      for (item <- list) {
        sum += item
      }

      sum
    }

    println(sum(List(1, 2, 3)))
  }

  def C(): Unit = {
    println("Task 1C:")

    def recursiveSum(list: List[Int], accSum: Int = 0): Int = {
      list match {
        case Nil => accSum
        case head :: tail => recursiveSum(tail, accSum + head)
      }
    } 

    println(recursiveSum(List(1, 2, 3)))
  }

  def D(): Unit = {
    println("Task 1D:")

    def recursiveFib(n: Int, prev: BigInt = 1, prevPrev: BigInt = 0): BigInt = {
      n match {
        case 0 => 0
        case 1 => prev
        case _ => recursiveFib(n-1, prev + prevPrev, prev)
      }
    } 

    println(recursiveFib(10))
  }
}

class Task2() {

  def helloWorld(): Unit = {
    println("HelloWorld!")
  }

  def makeConcurrent(func: () => Unit): Thread = {
      new Thread(new Runnable {
        def run(): Unit = {
          func()
        }
      })
    }

  def A() = {
    makeConcurrent(helloWorld).start()
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