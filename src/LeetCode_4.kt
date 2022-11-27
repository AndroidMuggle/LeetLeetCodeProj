/**
 * 寻找两个正序数组的中位数
困难
6.1K
相关企业
给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

算法的时间复杂度应该为 O(log (m+n)) 。



示例 1：

输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：

输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5




提示：

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
class LeetCode_4 {

    /**
     *
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val mergedArray = arrayListOf<Int>()
        var a = 0
        var b = 0
        while (a < nums1.size && b < nums2.size) {
            if (nums1[a] < nums2[b]) {
                mergedArray.add(nums1[a])
                a++
            } else {
                mergedArray.add(nums2[b])
                b++
            }
        }
        if (a < nums1.size) {
            while (a < nums1.size) {
                mergedArray.add(nums1[a])
                a++
            }
        }

        if (b < nums2.size) {
            while (b < nums2.size) {
                mergedArray.add(nums2[b])
                b++
            }
        }

        return if (mergedArray.size % 2 == 0) {
            (mergedArray[mergedArray.size / 2 - 1] + mergedArray[mergedArray.size / 2]) / 2.0
        } else {
            mergedArray[mergedArray.size / 2].toDouble()
        }
    }
}

fun main(args: Array<String>) {
    val func = LeetCode_4()
}