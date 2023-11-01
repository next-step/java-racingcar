package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text){
        int sum =0;
        boolean integerOrNot = false;

        // 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
        if (text == null){
            return sum;
        }
        if (text.isEmpty()) {
            return sum;
        }

        // 6. 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (예 : “-1,2,3”)
        if (text.contains("-")) throw new RuntimeException("음수를 전달할 경우 RuntimeException 예외가 발생!!");

        // 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
        integerOrNot = text.matches("-?\\d+");
        if(text.length()==1 && integerOrNot){
            int number = Integer.parseInt(text);
            return number;
        }

        // 3. 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
        // 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
        String[] numbers = text.split(",|:");
        // 앞 단계의 구분자가 없는 경우도 split()을 활용해 구현할 수 있는지 검토해 본다.
        for (int i = 0; i < numbers.length; i++) {

            integerOrNot = numbers[i].matches("-?\\d+");
            if(integerOrNot){
                sum += Integer.parseInt(numbers[i]);
            }

            if(i+1==numbers.length){
                return sum;
            }
        }


        // 5. “//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있다. (예 : “//;\n1;2;3” => 6)
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            // 덧셈 구현
            for (int i = 0; i < tokens.length; i++) {
                integerOrNot = tokens[i].matches("-?\\d+");
                if(integerOrNot){
                    sum += Integer.parseInt(tokens[i]);
                }
                if(i+1==tokens.length){
                    return sum;
                }
            }
        }

        return 0;
    }

}
