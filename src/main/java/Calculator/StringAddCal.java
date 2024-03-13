package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCal {
    private static Pattern ptn = Pattern.compile("//(.)\n(.*)");
    private StringAddCal(){
        // 생성자 접근을 private 으로 제한하여 객체 생성 방지
        // static 메소드로만 이루어져 있기 때문에 객체 호출이 필요 없음
    };
    public static int AddNumbers(String text) {
        if(text == null) return 0;
        if(text.isBlank()) return 0;
        return getSum(getIntegers(getValues(text)));
    }

    private static int[] getIntegers(String[] values) {
        int[] numbers = new int[values.length];
        for (int i=0; i<values.length; i++){
            numbers[i] = Integer.parseInt(values[i]); // 숫자가 아닌 문자의 경우 NumberFormatException 발생
            if(isNegative(numbers[i]) ==true) throw new RuntimeException("Negative Number Included");
        }
        return numbers;
    }

    private static boolean isNegative(int number) {
        if(number < 0) return true;
        else return false;
    }

    private static String[] getValues(String text) {
        if(text.contains("//")) {
            String delim = getCustomDelim(text);
            text = text.substring(4);
            return text.split(delim);
        }
        else return text.split(",|:"); // 두 구분자 사이에 공백이 있으면 안됨
    }

    private static String getCustomDelim(String text) {
        Matcher m = ptn.matcher(text);
        if (m.find()) {
            return m.group(1);
        }
        return null; // invalid
    }

    private static int getSum(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return sum;
    }
}
