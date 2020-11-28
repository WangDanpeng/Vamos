package wdp.struct.stack

/**
  * 数组实现的顺序栈
  * @param n
  */
class ArrayStack(n: Int) {
  // 参数
  var lenght = 0
  var data = new Array[String](n)

  // 入栈
  def pop(x: String): Unit ={
    if (lenght == data.length) {
      System.out.println("full")
    } else {
      data(lenght) = x
      lenght += 1
      System.out.println(s"pop $x")
    }
  }

  // 出栈
  def push(): Unit ={
    if (lenght == 0) {
      System.out.println("empty")
    } else {
      System.out.println(s"push ${data(lenght-1)}")
      lenght -= 1
    }
  }

  // todo 扩容

}

object ArrayStack {
  def main(args: Array[String]): Unit = {
    val arr = new ArrayStack(3)
    arr.pop("1")
    arr.pop("2")
    arr.pop("3")
    arr.pop("4")
    arr.pop("5")
    arr.push()
    arr.pop("6")
    arr.push()
    arr.push()
    arr.push()
    arr.push()
  }
}
