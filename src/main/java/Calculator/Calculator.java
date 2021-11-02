package Calculator;

import java.util.zip.DataFormatException;

public class Calculator {

    public Integer calculate(String input) throws DataFormatException {
        String[] arr = getSpaceSplitAndValidation(input);
        Integer result = Integer.parseInt(arr[0]);

        for(int i = 1; i < arr.length; i = i + 2) {
            try {
                result = EOperation.getValue(arr[i]).calculate(result, Integer.parseInt(arr[i + 1]));
            } catch (DataFormatException e) {
                throw new DataFormatException(e.getMessage() + " : " + arr[i]);
            }
        }

        return result;
    }

    private void validationParam(String input) {
        if(input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값이 존재하지 않습니다.");
        }
    }

    private String[] getSpaceSplitAndValidation(String input) {
        this.validationParam(input);
        String[] result = input.split(" ");

        if(!this.isOdd(result.length)) {
            throw new IllegalArgumentException("수식이 올바르지 않습니다.");
        }

        return result;
    }

    private Boolean isOdd(Integer number) {
        return number % 2 == 1;
    }

}
