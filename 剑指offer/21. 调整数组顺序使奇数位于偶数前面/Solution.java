//题目：
//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

class Solution {
    public int[] exchange(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            while (begin < end && (nums[begin] & 1) == 1) {
                begin++;
            }
            while (begin < end && (nums[end] & 1) != 1) {
                end--;
            }
            if (begin < end) {
                nums[begin] = nums[begin] ^ nums[end];
                nums[end] = nums[begin] ^ nums[end];
                nums[begin] = nums[begin] ^ nums[end];
            }
        }
        return nums;
    }
}