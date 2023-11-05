package step2;

import java.util.regex.Pattern;

public class StringAddCal {

    private static final String ONE_REGEX = "-?\\d";
    private static final Pattern ONE_PATTERN = Pattern.compile(ONE_REGEX);
    private static final String CUSTOM_REGEX = "//(.)\\n-?\\d(?:\\1-?\\d)+";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_REGEX);
    private static final String  DEFAULT_REGEX = "(?:-?\\d([,:]))+-?\\d";
    private static final Pattern DEFAULT_PATTERN = Pattern.compile(DEFAULT_REGEX);


    public int stringAdd(String given) {

        //빈문자열인 경우 null 리턴
        if (given == null || given.isBlank()) {
            return 0;
        }

        //문자열 추출
        String[] numbers = getSubString(given);

        //숫자의 합을 구함
        return getSum(numbers);
    }

    int getSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int result = Integer.parseInt(number);
            if (result < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
            sum += result;
        }
        return sum;
    }


    String[] getSubString(String given) {

        String[] result;
        result = getOneNumber(given);
        if(result.length !=0) return result;

        result = getDefaultString(given);
        if(result.length !=0) return result;

        result = getSlashString(given);

        return result;
    }

    String[] getSlashString(String given) {
        if (CUSTOM_PATTERN.matcher(given).matches()) {
            String delimiter = given.substring(2, 3);
            given = given.substring(4);
            return given.split(delimiter);
        }
        return new String[0];
    }

    String[] getDefaultString(String given) {
        if (DEFAULT_PATTERN.matcher(given).matches()) {
            return given.split("[,:]");
        }
        return new String[0];
    }

    String[] getOneNumber(String given) {
        if (ONE_PATTERN.matcher(given).matches()) {
            return given.split("[,:]");
        }
        return new String[0];
    }

}
