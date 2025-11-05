package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {


    public int isEmptyOrNull(String value) {
        return value == null || value.isEmpty() ? 0:-1;
    }

    public String[] split(String s) {
        return s.split("[,:]");
    }

    public int sum(String[] splitResult) {
        int sum = 0;
        for(String s: splitResult) {
            if (checkNoNum(s)) {
                throw new RuntimeException("숫자가 아닌 문자입니다.");
            }

            int num = Integer.parseInt(s);
            if(checkMinusNum(num)){
                throw new RuntimeException("음수일 수 없습니다.");
            }
            sum += num;
        }
        return sum;
    }
    public boolean checkNoNum(String str) {
        return !str.matches("-?\\d+");
    }
    public boolean checkMinusNum(int num) {
        return num < 0;
    }

    public String[] searchCustom(String s) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(s);
        if (m.find()) {
            String delimiter = m.group(1);
            String str = m.group(2);

            return str.split(delimiter);
        }
        return null;
    }
}
