import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator
{
    private static final String DELIMITER = ",|:";
    private static final int DELIMITER_GROUP_ID = 1;
    private static final int STRING_GROUP_ID = 2;

    public int add(String str){

        if(isBlank(str)){
            str = "0";
        }

        int[] intArr = toIntArr(split(str));

        return getSum(intArr);
    }

    private int[] toIntArr(String[] strArr) {
        int[] intArr = new int[strArr.length];
        for(int i = 0; i < strArr.length; i++){
            intArr[i] = toInt(strArr[i]);
        }
        return intArr;
    }

    private int toInt(String str) {
        int num = Integer.parseInt(str);
        if (num < 0){
            throw new IllegalArgumentException(num + "음수는 허용하지 않습니다.");
        }
        return num;
    }

    private static int getSum(int[] numbers) {
        int sum = 0;
        for(int num : numbers){
            sum += num;
        }
        return sum;
    }

    private static String[] split(String str) {
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if (m.find()) {
            String customDelimiter = m.group(DELIMITER_GROUP_ID);
            return m.group(STRING_GROUP_ID).split(customDelimiter);
        }
        return str.split(DELIMITER);
    }

    private static boolean isBlank(String str) {
        return str == null || str.isBlank();
    }
}