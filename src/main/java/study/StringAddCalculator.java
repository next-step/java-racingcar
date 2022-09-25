package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {


    public int splitAndSum(String data) {
        if(data == null || data.isEmpty()){
            return 0;
        }
        return dataSum(regexSplit(data));
    }

    private String[] regexSplit(String data) {
        Matcher pattern = Pattern.compile("//(.)\n(.*)").matcher(data);
        if (pattern.find()) {
            return pattern.group(2).split(pattern.group(1));
        }
        return data.split(",|:");
    }

    private int dataSum(String []dataList) {
        int sum = 0;
        for (String sumData : dataList) {
            if (parseInt(sumData) < 0) {
                throw new RuntimeException("음수가 들어왔습니다");
            } else {
                sum += parseInt(sumData);
            }
        }
        return sum;
    }

    private int parseInt(String data) {
        return Integer.parseInt(data);
    }

}