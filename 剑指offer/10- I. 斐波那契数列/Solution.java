//题目：写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。

class Solution {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
