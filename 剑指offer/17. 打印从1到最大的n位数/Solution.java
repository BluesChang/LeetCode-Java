//题目：
//输入数字n，按顺序打印出从1到最大的n位十进制数。比如输入3，则打印出1、2、3一直到最大的3位数999。
public class Solution {
    public static int[] printNumbers(int n) {
        StringBuilder str = new StringBuilder();
        List<Integer> list = new ArrayList();
        // 将str初始化为n个'0'字符组成的字符串
        for (int i = 0; i < n; i++) {
            str.append('0');
        }
        System.out.println(str.toString());
        while (!increment(str)) {
            // 去掉左侧的0
            int index = 0;
            while (index < str.length() && str.charAt(index) == '0') {
                index++;
            }
            // 将字符串转换为整数存入list中
            int temp = Integer.parseInt(str.substring(index));
            list.add(temp);
        }
        // 结果集
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private static boolean increment(StringBuilder str) {
        // 判断是否越界
        boolean isOverflow = false;
        // 从字符串的最后一位开始处理，即"数"的各位
        for (int i = str.length() - 1; i >= 0; i--) {
            // 获取该位的字符
            char s = (char) (str.charAt(i) + 1);
            // 如果s大于'9'则发生进位
            if (s > '9') {
                // 进位操作
                str.replace(i, i + 1, "0");
                // 如果此时i是最大位了
                if (i == 0) {
                    isOverflow = true;
                }
                System.out.println("if:" + str.toString());
            }
            // 没发生进位则跳出for循环，加1操作
            else {
                str.replace(i, i + 1, String.valueOf(s));
                break;
            }
        }
        return isOverflow;
    }
}