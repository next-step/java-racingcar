package Calculator;

import java.util.zip.DataFormatException;

public class Calculator {

    public Integer calculate(String input) throws DataFormatException {
        String[] arr = input.split(" ");
        // TODO arr[0]이 숫자가 아닐 경우
        Integer result = Integer.parseInt(arr[0]);

        for(int i = 1; i < arr.length; i = i + 2) {
            // TODO arr[i+1]이 숫자가 아니거나 없는 경우
            result = EOperation.getValue(arr[i]).calculate(result, Integer.parseInt(arr[i+1]));
        }

        return result;
    }

}
