package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private int calcStringWithDel(String text, String del) {
        int sum = 0;
        for (String s : text.split(del)) {
            int num = Integer.parseInt(s);
            if (num < 0) {
                throw new RuntimeException("음수값은 처리할 수 없습니다.");
            }
            sum += num;
        }
        return sum;
    }

    public int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String del = ",|:";
        String data = text;
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            del = m.group(1);
            data = m.group(2);
        }
        return calcStringWithDel(data, del);
    }

}
