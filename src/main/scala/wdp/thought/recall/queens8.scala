package wdp.thought.recall

object queens8 {
  val result = new Array[Int](8)

  def queens8(row: Int): Unit ={
    if (row == 8) {
      print("over")
      return
    }
    for (column <- 0 until 8) {
      if (isOk(row, column)) {
        result(row) = column
        queens8(row+1)
      }
    }
  }

  def isOk(row: Int, column: Int): Boolean ={
    var leftUp = column - 1
    var rightUp = column + 1
    for (i <- row-1 to 0) {
      if (result(i) == column) return false
      if (leftUp >= 0) {
        if (result(i) == leftUp) return false
      }
      if (rightUp < 8) {
        if (result(i) == rightUp) return false
      }
      leftUp -= 1
      rightUp += 1
    }

    true
  }




  def main(args: Array[String]): Unit = {

  }
}
