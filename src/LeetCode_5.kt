/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。

示例 2：

输入：s = "cbbd"
输出："bb"
 */
class LeetCode_5 {
    // todo 考察的是动态规划方法，中心扩散法，manacher算法（此问题的终极解法），此方法为暴力解法
    fun longestPalindrome(s: String): String {
        if (s.length == 1) {
            return s
        }
        // 最大回文子串的起始和结束位置
        var startIndex = 0
        var endIndex = 1
        // 最小是自身
        var result = "" + s[0]
        while (startIndex < s.length && endIndex < s.length) {
            val subs = s.substring(startIndex, endIndex + 1)
            if (subs.length > result.length && isPalindrome(subs)) {
                result = subs
            }
            endIndex++
            if (endIndex == s.length) {
                startIndex++
                endIndex = startIndex + 1
            }
        }
        return result
    }

    /**
     * 判断是否为回文字串
     */
    private fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.length - 1
        while (start <= end && start < s.length && end >= 0) {
            if (s[start] != s[end]) {
                return false
            } else {
                start++
                end--
            }
        }
        return true
    }
}


fun main(args: Array<String>) {
    val func = LeetCode_5()
    val s = func.longestPalindrome("ac")
    print("s = $s")
}

/**
 * 动态规划的题目，通常存在明确的状态转移的方法；
 * 根据上一次的结果，进行状态转移，进行状态填表；
 * 考察状态转移方程的推导
 */