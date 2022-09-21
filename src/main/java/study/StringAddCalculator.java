package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public int splitAndSum(String data) {
        int number = 0;

        if (data == null || data.isEmpty()) {
            return 0;
        }

        if (data.length() == 1) {
            return number = Integer.parseInt(data);
        }

        Matcher pattern = Pattern.compile("//(.)\n(.*)").matcher(data);
        if (pattern.find()) {
            number = dataSum(pattern.group(2), pattern.group(1), 0);
        }else{
            number = dataSum(data, ",|:", 0);
        }

        return number;
    }

    private int dataSum(String data, String regex, int sum) {
        String[]dataList = data.split(regex);
        for (String sumData : dataList) {
            if (Integer.parseInt(sumData) < 0) {
                throw new RuntimeException("음수가 들어왔습니다");
            } else {
                sum += Integer.parseInt(sumData);
            }
        }
        return sum;
    }

}
