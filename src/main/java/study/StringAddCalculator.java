package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static void main(String[] args) {
        System.out.println("문자열 덧셈 결과입니다 : " + splitAndSum("1,2,3"));
    }

    public static int splitAndSum(String data) {
        if(data == null || data.isEmpty()){
            return 0;
        }
        return dataSum(regexSplit(data));
    }

    private static String[] regexSplit(String data) {
        Matcher pattern = Pattern.compile("//(.)\n(.*)").matcher(data);
        if (pattern.find()) {
            return pattern.group(2).split(pattern.group(1));
        }
        return data.split(",|:");
    }

    private static int dataSum(String []dataList) {
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

    private static int parseInt(String data) {
        return Integer.parseInt(data);
    }

}