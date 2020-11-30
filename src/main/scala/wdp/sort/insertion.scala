package wdp.sort

/**
  * 插入排序
  */
object insertion {
  def main(args: Array[String]): Unit = {
    val array = Array(9, 5, 2, 7, 1, 2, 3, 8)
    println(array.mkString(" "))
    // 已排序区从0下标开始, 排完一个向右扩大一个
    for (i <- 1 until array.length) {
      // 比较已排序区元素, 寻找合适位置插入
      for (j <- 0 until i) {
        if (array(i) < array(j)) {
          val temp = array(i)
          // 将插入位置后面的元素全部后移一位
          for (k <- Range(i, j, -1)) {
            array(k) = array(k-1)
            println(array.mkString(" "))
          }
          array(j) = temp
          println(array.mkString(" "))
        }
      }
    }
    println(array.mkString(" "))
  }
}
