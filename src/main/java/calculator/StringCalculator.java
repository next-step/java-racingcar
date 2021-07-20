package calculator;

public class StringCalculator {

    public int calculate(String value) {
        String[] valueArray = stringBySplit(value);
        validValueArraySize(valueArray.length);
        int result = valueArrForResult(valueArray);
        return result;
    }

    private int valueArrForResult(String[] valueArr) {
        int result = toInt(valueArr[0]);
        for (int i = 0; i < valueArr.length - 2; i += 2) {
            result = calculate(result, valueArr[i + 1], toInt(valueArr[i + 2]));
        }
        return result;
    }

    private int calculate(int firstValue, String expressionLabel, int lastValue) {
        return Calculation.calculateValue(expressionLabel, firstValue, lastValue);
    }

    public String[] stringBySplit(String value) {
        return value.split(" ");
    }

    public int toInt(String value) {
        validByNumberCheck(value);
        return Integer.parseInt(value);
    }

    private void validByNumberCheck(String value) {
        String regExp = "^[0-9]+$";
        if(!value.matches(regExp)){
            throw new IllegalArgumentException("해당 문자는 숫자만 사용 가능합니다.");
        }
    }

    private void validValueArraySize(int arraySize) {
        if (arraySize < 3) {
            throw new IllegalStateException("배열의 길이는 최소 3이상 이어야 합니다.");
        }
    }

}
