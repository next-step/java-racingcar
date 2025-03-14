import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator
{
    /*
    쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
    (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
    앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.
    커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
    문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.
     */
    private static String DELIMITER = ",|:";

    public int add(String str){
        return getSum(toIntArr(getStringWhenHasDelimiter(getZeroWhenBlank(str)).split(DELIMITER)));
    }

    private int[] toIntArr(String[] strArr) {
        int[] intArr = new int[strArr.length];
        for(int i = 0; i < strArr.length; i++){
            intArr[i] = toInt(strArr[i]);
        }
        return intArr;
    }

    private int toInt(String s) {
        int num = Integer.parseInt(s);
        if(num < 0){
            throw new RuntimeException("음수는 허용하지 않습니다.");
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

    private static String getStringWhenHasDelimiter(String str) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(str);

        if(matcher.find()){
            DELIMITER = matcher.group(1);
            return matcher.group(2);
        }
        return str;
    }

    private static String getZeroWhenBlank(String str) {
        return str == null || str.isBlank() ? "0" : str;
    }
}
