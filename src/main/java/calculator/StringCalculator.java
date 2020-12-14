package calculator;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public int calculation(String input) {
        nullAndEmptyCheck(input);
        List<String> inputArray = Arrays.asList(input.split(" "));
        int result = parseInt(inputArray.get(0));

        for(int i=1; i < inputArray.size(); i += 2) {
            result = Operation.arithmeticOperationCheck(inputArray.get(i)).operation(result, parseInt(inputArray.get(i+1)));
        }
        return result;
    }

    private int parseInt(String input) {
        return Integer.parseInt(input);
    }

    void nullAndEmptyCheck(String input) {
        if(input == null || input.isEmpty())
            Exception.IllegalArgumentException("null 또는 빈값을 허용하지 않습니다.");
    }
}
