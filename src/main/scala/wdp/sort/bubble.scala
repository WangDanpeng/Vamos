package wdp.sort

object bubble {
  def main(args: Array[String]): Unit = {
    val array = Array(9, 5, 2, 7, 1, 2, 3, 8)
    println(array.mkString(" "))

    // 需要交换的次数, 排好的元素越多, 后续交换次数越少
    for (i <- Range(array.length-1, 0, -1)) {
      var count = 0
      for (j <- Range(0, i)) {
        if (array(j) > array(j+1)) {
          val temp = array(j)
          array(j) = array(j+1)
          array(j+1) = temp
          count += 1
          println(array.mkString(" "))
        }
      }
      // 没有交换次数说明已排好序
      if (count == 0) return
    }
  }
}
