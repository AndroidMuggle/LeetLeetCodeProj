/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。

如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。

假设环境不允许存储 64 位整数（有符号或无符号）。


示例 1：

输入：x = 123
输出：321
示例 2：

输入：x = -123
输出：-321
示例 3：

输入：x = 120
输出：21
示例 4：

输入：x = 0
输出：0


提示：

-231 <= x <= 231 - 1
 */
class LeetCode_7 {

    /**
     * 此解法作弊了  使用了long类型，需要思考判断和极限值的比对情况
     */
    fun reverse(x: Int): Int {
        val numArray = arrayListOf<Long>()
        var inputNum = x
        while (inputNum != 0) {
            val num = inputNum % 10
            numArray.add(num.toLong())
            inputNum /= 10
        }
        numArray.reverse()
        var ret = 0L
        var decimal = 1
        numArray.forEach {
            val num: Long = it * decimal
            ret += num
            decimal *= 10
        }
        return if (ret > Int.MAX_VALUE || ret < Int.MIN_VALUE) 0 else ret.toInt()
    }
}

fun main() {
    val func = LeetCode_7()
    val ret = func.reverse(1534236469)
    print(ret)
}