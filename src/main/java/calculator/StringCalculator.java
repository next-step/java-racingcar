package calculator;

public class StringCalculator {

    public int calculate(String value) {
        String[] valueArr = stringBySplit(value);
        validValueArraySize(valueArr.length);
        int result = valueArrForResult(valueArr);
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
        return Integer.parseInt(value);
    }

    public void validValueArraySize(int arraySize) {
        if (arraySize < 3) {
            throw new IllegalStateException("배열의 길이는 최소 3이상 이어야 합니다.");
        }
    }

}
