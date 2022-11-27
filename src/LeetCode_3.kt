/**
 * 3. 无重复字符的最长子串
中等
8.4K
相关企业
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。



示例 1:

输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


提示：

0 <= s.length <= 5 * 104
s 由英文字母、数字、符号和空格组成
 */
class LeetCode_3 {
    /**
     * 高耗时方法，本意是考察滑动窗口法
     */
    fun lengthOfLongestSubstring(s: String): Int {
        var startIndex = 0
        val curSubString: HashSet<Char> = HashSet()
        var maxCount = 0
        var ret = 0
        var index = 0
        while (startIndex < s.length && index < s.length) {
            if (curSubString.contains(s[index])) {
                //包含当前字符，则清空集合，
                startIndex++
                maxCount = curSubString.size
                curSubString.clear()
                index = startIndex
                ret = maxCount.coerceAtLeast(ret)
                maxCount = 0
            } else {
                curSubString.add(s[index])
                index++
                maxCount++
                ret = ret.coerceAtLeast(maxCount)
            }
        }
        return ret
    }

    companion object {

    }
}

fun main(args: Array<String>) {
    var input = "pwwkew"
    var func = LeetCode_3()
    func.lengthOfLongestSubstring(input)
}