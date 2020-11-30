package wdp.struct.link

class Node(var data: String, var next: Node)

class LRU(length: Int){
  // 缓存长度有上限
  var head: Node = _
  var count = 0

  // 插入节点
  def add(s: String): Unit ={
    val (r, per) = scan(s)
    if (r != null){
      delete(r, per)
      addToHead(s)
    } else {
      // 已满, 删除尾结点, 插入头结点
      if (count >= length) {
        val (r, per) = scanEnd()
        delete(r, per)
        addToHead(s)
      } else {
        addToHead(s)
      }
    }
  }

  // 头插
  def addToHead(s: String): Unit ={
    val n = new Node(s, head)
    head = n
    count += 1
    println(s"头插节点$s, $count")
  }

  // 删除节点
  def delete(n: Node, per: Node): Unit ={
    if (n == head) {
      if (count == 1) {
        head = null
      } else {
        head = head.next
      }
    } else {
      per.next = n.next
    }
    count -= 1
    println(s"删除节点${n.data}, $count")
  }

  // 查找节点
  def scan(s: String): (Node, Node) ={
    if (head == null) {
      return (null, null)
    } else if (head.data == s) {
      return (head, null)
    }
    var t = head
    var per = t
    while (t.next != null){
      per = t
      t = t.next
      if(t.data == s) {
        return (t, per)
      }
    }
    (null, null)
  }

  def scanEnd(): (Node, Node) ={
    var t = head
    var per = t
    while (t.next != null) {
      per = t
      t = t.next
    }
    (t, per)
  }

  def print(): Unit ={
    var t = head
    while (t != null) {
      println(t.data)
      t = t.next
    }
  }


}

object LRU {

  def main(args: Array[String]): Unit = {
    // 测试
    val r = new LRU(4)
    r.print()
    r.add("aaa")
    println("=====")
    r.add("bbb")
    println("=====")
    r.add("aaa")
    println("=====")
    r.add("ccc")
    println("=====")
    r.add("ccc")
    println("=====")
    r.add("ddd")
    println("=====")
    r.add("eeee")
    println("=====")
    r.print()
  }
}