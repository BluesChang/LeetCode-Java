//题目：
//        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的
//        最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。

class Solution {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int middle = (low + high) / 2;
            if (numbers[middle] < numbers[high]) {
                high = middle;
            } else if (numbers[middle] > numbers[high]) {
                low = middle + 1;
            } else {
                high--;
            }
        }
        return numbers[low];
    }
}