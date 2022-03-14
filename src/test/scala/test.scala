object Solution {
  def subArrayRanges(nums: Array[Int]): Long = {
    val lenght = nums.size
    var res: Long = 0
    for (i <- 2 to lenght) {
      var left = 0
      var right = left + i -1
      while(right<=lenght-1){
        val arr = nums.slice(left,right+1)
        res = res + summ(arr)
        println(res)
        left = left + 1
        right = right + 1
      }
    }
    res
  }

  def summ(arr: Array[Int]): Long = {
    var min = arr(0)
    var max = arr(0)
    for (i <- arr) {
      if (i>max) {
        max = i
      }
      if (i<min) {
        min = i
      }
    }
    max-min
  }

  def main(args: Array[String]): Unit = {
    val aaa = Array(1, 2, 3)
    println(subArrayRanges(aaa))
  }
}