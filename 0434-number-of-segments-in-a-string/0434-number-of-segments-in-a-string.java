class Solution {
    public int countSegments(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] != ' ') {
                if (i - 1 < 0) {
                    ++res;
                } else {
                    if (chars[i - 1] == ' ') {
                        ++res;
                    }
                }
            }
        }
        return res;
    }
}