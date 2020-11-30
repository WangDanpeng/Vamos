package wdp.struct.link

class SingleLink{
  var head: Node = _
  var length = 0

  def addToHead(s: String): Unit ={
    val n = new Node(s, head)
    head = n
    length += 1
    println(s"头插节点$s, $length")
  }

  def reverse(): Unit ={
    if (length < 2) return
    var t = head
    var n = t.next
    var p: Node = null
    while (t != null) {
      t.next = p
      p = t
      t = n
      if (n != null) n = n.next
    }
    head = p
  }

  def print(): Unit ={
    var t = head
    while (t != null) {
      println(t.data)
      t = t.next
    }
  }

}

object ReverseSingleLink{
  def main(args: Array[String]): Unit = {
    val s = new SingleLink()
    s.addToHead("111")
    s.addToHead("222")
    s.addToHead("333")
    s.addToHead("444")
    s.print()
    println("=========")
    s.reverse()
    s.print()
  }
}