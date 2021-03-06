//题目：剪绳子
//        给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1,m>1），  每段绳子的长度记为 k[0], k[1], k[2], …, k[m]。
//        请问 k[0] * k[1] * k[2] * … * k[m] 可能的最大乘积是多少？例如，当绳子的长度为8时，我们把它剪成长度分别为2、3、3的三段，
//        此时得到的最大乘积是18。

class Solution {
    public int cuttingRope(int n) {
        if (n < 4) {
            return n - 1;
        }
        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }
}