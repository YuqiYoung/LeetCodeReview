//https://leetcode.com/problems/binary-watch/
//the idea is using the bit. According to definition the max result is 11:59 (1011111011) so we could use 1024(1111111111) as the max
//because the result of Integer.toBinaryString(int i) will remove the lead 0, for example. Integer.toBinaryString(1) will return 1, but we are
//expecting '0000000001', so we add lead zero instead.
public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<String>();
        for (int i=0; i < 1024; i++) {
            String str = Integer.toBinaryString(i);
            int cntOne = countOne(str);
            int curLength = str.length();
            if (cntOne == num) {
                for (int j = 0; j < 10 - curLength; j++) {
                    str = "0" + str;
                }
                String minPart = str.substring(4,10);
                String hourPart = str.substring(0,4);
                int min = Integer.parseInt(minPart, 2);
                int hour = Integer.parseInt(hourPart, 2);
                if (hour <= 11 && min <= 59) {
                    String tmp = hour + ":";
                    if (min < 10) { // according to Definition
                        tmp = tmp + "0" + min;
                    } else {
                        tmp = tmp + min;
                    }
                    res.add(tmp);
                }
            }
        }
        return res;
    }
    
    //count the number of '1' which occurs in the string. 
    public int countOne(String str) {
        int cnt = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }
}