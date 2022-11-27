/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 */
class LeetCode_2 {

    /**
     * 此方法不是最优解
     */
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var ret: ListNode? = ListNode(0)
        val firstNode = ret
        var plusFlag = false
        var l1Temp = l1
        var l2Temp = l2
        // todo 可以while修改判断条件，优化代码做法null != l1Temp || null != l2Temp
        while (null != l1Temp && null != l2Temp) {
            var sum = l1Temp.value + l2Temp.value
            if (plusFlag) {
                sum += 1
            }
            if (sum >= 10) {
                sum %= 10
                plusFlag = true
            } else {
                plusFlag = false
            }
            ret?.next = ListNode(sum)
            l1Temp = l1Temp.next
            l2Temp = l2Temp.next
            ret = ret?.next
        }

        while (null != l1Temp) {
            if (plusFlag) {
                var sum: Int = l1Temp.value + 1
                if (sum >= 10) {
                    sum %= 10
                    plusFlag = true
                } else {
                    plusFlag = false
                }
                ret?.next = ListNode(sum)
            } else {
                ret?.next = ListNode(l1Temp.value)
            }
            ret = ret?.next
            l1Temp = l1Temp.next
        }
        while (null != l2Temp) {
            if (plusFlag) {
                var sum: Int = l2Temp.value + 1
                if (sum >= 10) {
                    sum %= 10
                    plusFlag = true
                } else {
                    plusFlag = false
                }
                ret?.next = ListNode(sum)
            } else {
                ret?.next = ListNode(l2Temp.value)
            }
            ret = ret?.next
            l2Temp = l2Temp.next
        }
        if (plusFlag){
            ret?.next = ListNode(1)
        }
        return firstNode?.next
    }
}

class ListNode(var value: Int) {
    var next: ListNode? = null
}