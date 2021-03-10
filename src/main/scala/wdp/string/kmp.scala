package wdp.string

object kmp {
  def kmp(major: String, pattern: String): Int ={
    // 主串的长度
    val mLength = major.length
    // 模式串的长度
    val pLength = pattern.length

    // 预处理失效函数
    val next: Array[Int] = getNexts(pattern, pLength)
    // 模式串匹配位置
    var j = 0
    // 从主串开头开始匹配
    for (i <- 0 until mLength) {
      // 处理当前字符不相等的情况
      while (j>0 && major(i)!=pattern(j)) {
        // j位置的字符没有匹配上, 所以0到j-1位置都是好前缀
        // next(j-1)就是去找当前好前缀的最长可匹配前缀子串, 然后向后滑动
        // 当不存在时返回-1, 则j=0, 表示从模式串的头上重新开始匹配
        j = next(j-1) + 1
      }
      // 当前字符相等, 准备对比下一个字符
      if (major(i) == pattern(j)) {
        j += 1
      }
      // 当已经匹配到模式串的尾部, 表示模式串匹配上了, 算法结束
      if (j == pLength) {
        // 返回主串中的开始位置
        return i-pLength+1
      }
    }
    -1
  }

  /***
    * 预处理模式串得到next数组
    * @param pattern 模式串
    * @param pLength 模式串长度
    * @return 返回处理好的next数组
    */
  def getNexts(pattern: String, pLength: Int): Array[Int] ={
    // 先new一个模式串等长的数组
    val next: Array[Int] = new Array[Int](pLength)
    // 当好前缀长度为1时, 不存在子串, 所以它没有最长可匹配前缀子串
    next(0) = -1
    // k表示最长可匹配前缀的结尾字符下标, 初始化为-1(不存在)
    var k = -1
    for (i <- 1 until pLength) {
      // 处理当新字符i和上一个最长可匹配前缀子串的后一位不相等的情况
      while (k!= -1 && pattern(k+1)!=pattern(i)){
        // 本函数的核心代码
        // 因为上一个最长可匹配前缀子串的后一位和字符i不相等
        // 需要再往上倒, 去寻找上一个次长的可匹配前缀子串
        // 然后继续对比后一位字符, 若还是不相等, 则再找次次长
        // 直到和字符i相等, 或k变为-1, 不存在最长可匹配前缀子串为止
        k = next(k)
      }
      // 比较上一个最长可匹配前缀的后面一位字符, 和当前下标i的字符是否一致
      // 一致则当前好前缀的最长可匹配前缀子串就是上一个最长可匹配前缀子串加一位字符, 即0到k+1位
      if (pattern(k+1) == pattern(i)) {
        k += 1
      }
      // 设置当前长度到i的好前缀的最长可匹配前缀子串的结尾字符下标为更新后的k
      next(i) = k
    }
    // 返回处理好的next数组
    next
  }

  def main(args: Array[String]): Unit = {
    println(kmp("ababaeababac", "ababac"))
  }

}
