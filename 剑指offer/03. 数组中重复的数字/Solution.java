//题目：
//        在一个长度为n的数组里有所有数字都在0~n-1的范围内，数组中某些数字是重复的，但不知道有几个数字重复了，
//        也不知道每个数字重复了几次，请找出数组中任意一个重复的数字，例如，如果输入长度为7的数组 [ 2, 3, 1, 0, 2, 5, 3 ] ，
//        那么对应的输出是重复的数字2或者3。
//        对原数组进行排序然后顺序查找，时间 O(nlogn) 空间 O(1)
//        利用哈希表解决，无需修改原数组，时间 O(n) 空间 O(n)
//        交换原数组中的元素，时间 O(n) 空间 O(1)
//        第三种方法最优，以下是实现
class Solution {
    public int findRepeatNumber(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}