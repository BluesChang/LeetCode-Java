//题目：请实现一个函数，将一个字符串中的空格替换成“%20”。
//        例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。

class Solution {
    public String replaceSpace(String s) {
        int length = s.length();
        int blankCount = 0;
        for (int i = 0; i < length; i++) {
            if (' ' == (s.charAt(i))) {
                blankCount++;
            }
        }
        char[] array = new char[length + blankCount * 2];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}
