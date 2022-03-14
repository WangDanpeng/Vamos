package wdp.struct.link

class SingleLink{
  var head: Node = _
  var end: Node = _
  var length = 0

  def addToHead(s: String): Unit ={
    val n = new Node(s, head)
    head = n
    if (length == 0) {
      end = head
    }
    length += 1
  }

  def addToEnd(s: String): Unit ={
    val n = new Node(s, null)
    if (length == 0) {
      head = n
      end = head
    } else {
      end.next = n
      end = n
    }
    length += 1
  }

  /**
    * 构建一个环形链表
    */
  def circular(): Unit ={
    end.next = head
  }

  /**
    * 单链表反转
    */
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
      printf(t.data + ", ")
      t = t.next
    }
    println()
  }

}

object ReverseSingleLink{
  def main(args: Array[String]): Unit = {
    // 单链表反转
    val s = new SingleLink()
    s.addToHead("111")
    s.addToHead("222")
    s.addToHead("333")
    s.print()
    s.reverse()
    s.print()

    // 检测链表有环
    var i = s.head
    var j = s.head
    s.circular()
    while(j != null) {
      i = i.next
      if (j.next != null) {
        j = j.next.next
        if (i == j) {
          println("有环")
          return
        }
      } else {
        return
      }
    }

    // 合并两个有序的链表
    val left = new SingleLink()
    left.addToEnd("1")
    left.addToEnd("3")
    left.addToEnd("7")
    left.addToEnd("9")
    left.print()
    val right = new SingleLink()
    right.addToEnd("2")
    right.addToEnd("4")
    right.addToEnd("6")
    right.print()
    val res = new SingleLink()
    var l = left.head
    var r = right.head
    while (l != null && r != null) {
      if (l.data> r.data) {
        res.addToEnd(r.data)
        r = r.next
      } else {
        res.addToEnd(l.data)
        l = l.next
      }
    }
    if (l == null) {
      res.end.next = r
    } else {
      res.end.next = l
    }
    res.print()

  }
}