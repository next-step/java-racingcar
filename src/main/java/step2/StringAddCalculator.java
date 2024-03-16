package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String input){
        if(isNullOrEmpty(input)) return 0;
        int result = calculate(input);

        return result;
    }

    private static boolean isNullOrEmpty(String input){
        if(input == null || input.isEmpty()){
            return true;
        }
        return false;
    }

    private static String[] parseInput(String input){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()){
            String customSeparator = m.group(1);
            String[] tokens = m.group(2).split(customSeparator);

            return tokens;
        }

        if(!m.find()){
            String[] tokens = input.split(",|:");

            return tokens;
        }

        return new String[]{};
    }

    private static int calculate(String input){
        int result = 0;
        String[] tokens = parseInput(input);
        for(String element : tokens ){
            result += Integer.parseInt(element);
        }

        return result;
    }


    //    쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: “” => 0, "1,2" => 3, "1,2,3" => 6, “1,2:3” => 6)
    //    앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
    //    문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

}

