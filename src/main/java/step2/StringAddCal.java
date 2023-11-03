package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCal {

    public int stringAdd(String given) {

        //빈문자열인 경우 null 리턴
        if(given == null || given.isEmpty() || given.trim().isEmpty()) {
            return 0;
        }

        //string 길이가 1인 경우 처리
        if(given.length() == 1) {
            return Integer.parseInt(given);
        }

        //문자열 추출
        String[] strNumbers = getSubString(given);

        //숫자의 합을 구함
        return getSum(strNumbers);
    }

    int getSum(String[] strNumbers) {
        int sum = 0;
        for(String strNumber : strNumbers) {
            int number = Integer.parseInt(strNumber);
            if(number < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
            sum += number;
        }
        return sum;
    }


    String[] getSubString(String given) {

        String[] given1 = getDefaultString(given);
        if (given1 != null) return given1;

        String[] given2 = getSlashString(given);
        if (given2 != null) return given2;

        return null;
    }

    String[] getSlashString(String given) {
        String slashRegex = "//(.)\\n-?\\d(?:\\1-?\\d)+";
        if(given.matches(slashRegex)) {
            String delimiter = given.substring(2, 3);
            given = given.substring(4);
            return given.split(delimiter);
        }

/*        String slashRegex1 = "//(.)\\n-?\\d(?:\\1-?\\d)+";
        Matcher matcher = Pattern.compile(slashRegex).matcher(given);
        if(matcher.find()) {
            String delimiter = matcher.group(1);
            given = given.substring(4);
            return given.split(delimiter);
        }*/

        return null;
    }

    String[] getDefaultString(String given) {
        String defaultRegex = "(?:-?\\d([,:]))+-?\\d";
        if(given.matches(defaultRegex)) {
            return given.split("[,:]");
        }
        return null;
    }

}
