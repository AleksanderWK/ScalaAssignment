class Task1 {

  def a(): Unit = {
    println("Task 1A:")

    var nums: List[Int] = List()

    for (n <- 1 to 50){
      nums = nums :+ n
    }

    println(nums)
  }
  
  def b(): Unit = {
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

  def c(): Unit = {
    println("Task 1C:")

    def recursiveSum(list: List[Int], accSum: Int = 0): Int = {
      list match {
        case Nil => accSum
        case head :: tail => recursiveSum(tail, accSum + head)
      }
    } 

    println(recursiveSum(List(1, 2, 3)))
  }

  def d(): Unit = {
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

  def makeConcurrent(func: () => Unit): Thread = {
      new Thread {
        override def run() = {
          func()
        }
      }
    }

  def a() = {
    println("Task 2A:")

    def helloWorld(): Unit = {
      println("Hello World!")
    }

    val hello = makeConcurrent(helloWorld)

    hello.start()
    hello.join()
  }

  def b(): Unit = {
    println("Task 2B:")

    var counter: Int = 0

    def increaseCounter(): Unit = {
      counter += 1
    }

    def printCounter(): Unit = {
      println(counter)
    }

    val a = makeConcurrent(increaseCounter)
    val b = makeConcurrent(increaseCounter)
    val c = makeConcurrent(printCounter)

    a.start()
    b.start()
    c.start()

    a.join()
    b.join()
    c.join()
  }

  def c(): Unit = {
    println("Task 2C:")

    var counter: Int = 0

    def increaseCounter(): Unit = this.synchronized {
      counter += 1
    }

    def printCounter(): Unit = {
      println(counter)
    }

    val a = makeConcurrent(increaseCounter)
    val b = makeConcurrent(increaseCounter)
    val c = makeConcurrent(printCounter)

    a.start()
    b.start()
    c.start()

    a.join()
    b.join()
    c.join()
  }

  def d(): Unit = {
    println("Task 2D:")

    lazy val x: String = {
      val t = makeConcurrent(() => { println(x) })
      t.start()
      t.join()
      "Never printed, because of a deadlock"
    }

    println(x)
  }
}


object Main extends App {
  val task1 = new Task1
  val task2 = new Task2
  task1.a()
  task1.b()
  task1.c()
  task1.d()
  task2.a()
  task2.b()
  task2.c()
  task2.d()

}