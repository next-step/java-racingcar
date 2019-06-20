package homework.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    static final String PLUS_SYMBOL = "+";
    static final String MINUS_SYMBOL = "-";
    static final String MULTIPLY_SYMBOL = "*";
    static final String DIVISION_SYMBOL = "/";
    static final String NUMBER_REGEX = "^[0-9]*$";
    static final String SEPARATOR_STRING = " ";
    static final String EMPTY_STRING = "";
    static final int MIN_ELEMENT_STRING_ARRAY_LENGTH = 3;

    private String inputString;
    private List<Integer> numberElementList;
    private List<String> operationalSymbolElementList;

    public StringCalculator(String inputString) {
        this.inputString = inputString;
    }

    public List<Integer> getNumberElementList() {
        return numberElementList;
    }

    public List<String> getOperationalSymbolElementList() {
        return operationalSymbolElementList;
    }

    void validateInputString() throws IllegalArgumentException {
        if (inputString == null
                || inputString.isEmpty()
                || inputString.replaceAll(SEPARATOR_STRING, EMPTY_STRING).isEmpty()) {
            throw new IllegalArgumentException("입력값은 null, 빈 문자열, 공백 문자열로만 이루어진 것을 허용하지 않습니다!");
        }
    }

    String[] splitInputString() {
        return inputString.split(SEPARATOR_STRING);
    }

    void validateElementStringArrayLength(String[] elementStringArray) throws IllegalArgumentException {
        if (elementStringArray.length < MIN_ELEMENT_STRING_ARRAY_LENGTH) {
            throw new IllegalArgumentException("입력값은 최소 계산 할 두개의 숫자와 하나의 사칙연산 기호로 이루어져야 합니다.");
        }
        if (elementStringArray.length % 2 != 1) {
            throw new IllegalArgumentException("입력값은 계산할 숫자문자열과 사칙연산기호 문자열의 개수를 더 했을 때 홀수로 이루어져야 합니다.");
        }
    }

    void validateElementStringArrayFirstValueAndLastValue(String[] elementStringArray) {
        validateNumberStringValue(elementStringArray[0]);
        validateNumberStringValue(elementStringArray[elementStringArray.length - 1]);
    }

    void validateNumberStringValue(String stringValue) throws IllegalArgumentException {
        if (!Pattern.matches(NUMBER_REGEX, stringValue)) {
            throw new IllegalArgumentException("숫자형태 문자열이 와야 할 자리에 다른형태 문자열이 있습니다.");
        }
    }

    void validateOperationalSymbolStringValue(String stringValue) throws IllegalArgumentException {
        if (!PLUS_SYMBOL.equals(stringValue)
                && !MINUS_SYMBOL.equals(stringValue)
                && !MULTIPLY_SYMBOL.equals(stringValue)
                && !DIVISION_SYMBOL.equals(stringValue))
            throw new IllegalArgumentException("사칙연산기호 문자열이 와야 할 자리에 다른형태 문자열이 있습니다.");
    }

    List<String> getNumberStringElementList(String[] elementStringArray) {
        List<String> numberStringElementList = new ArrayList();
        for (int index = 0; index < elementStringArray.length; index += 2) {
            numberStringElementList.add(elementStringArray[index]);
        }
        return numberStringElementList;
    }

    void setOperationalSymbolElementList(String[] elementStringArray) {
        operationalSymbolElementList = new ArrayList();
        for (int index = 1; index < elementStringArray.length; index += 2) {
            operationalSymbolElementList.add(elementStringArray[index]);
        }
    }

    void validateNumberStringElementListValues(List<String> numberStringElementList) {
        for (String numberString : numberStringElementList) {
            validateNumberStringValue(numberString);
        }
    }

    void validateOperationalSymbolElementListValues() throws IllegalArgumentException {
        for (String operationalSymbolString : operationalSymbolElementList) {
            validateOperationalSymbolStringValue(operationalSymbolString);
        }
    }

    void setNumberElementList(List<String> numberStringElementList) {
        numberElementList = new ArrayList<>();
        for (String numberString : numberStringElementList) {
            numberElementList.add(Integer.parseInt(numberString));
        }
    }

    void prepareForCalculate(StringCalculator stringCalculator) {
        // 입력 문자열 null or empty string or white space string validation check
        stringCalculator.validateInputString();
        // 입력 문자열 split
        String[] elementStringArray = stringCalculator.splitInputString();
        // 쪼갠 문자열 요소 배열길이 validation check
        stringCalculator.validateElementStringArrayLength(elementStringArray);
        // 조갠 문자열 요소 배열의 첫번째 value, 마지막 value validation check
        stringCalculator.validateElementStringArrayFirstValueAndLastValue(elementStringArray);
        // 문자열 요소 배열의 인덱스가 0 포함 짝수인 값들만 사직연산 기호 문자열 리스트에 담는다.
        List<String> numberStringElements = stringCalculator.getNumberStringElementList(elementStringArray);
        // 문자열 요소 배열의 인덱스가 홀수인 값들만 사직연산 기호 문자열 리스트에 담는다.
        stringCalculator.setOperationalSymbolElementList(elementStringArray);
        // 문자열 요소 배열의 인덱스가 짝수 번째 문자열은 숫자형태로만 이루어져야 한다.
        stringCalculator.validateNumberStringElementListValues(numberStringElements);
        // 문자열 요소 배열의 인덱스가 홀수 번째 문자열은 사칙연산 기호로만 이루어져야 한다.
        stringCalculator.validateOperationalSymbolElementListValues();
        // 숫자형태 문자열 리스트 value를 Integer로 parse 후 numberElementList add
        stringCalculator.setNumberElementList(numberStringElements);
    }

    int plus(int result, int value, String symbol) {
        if (PLUS_SYMBOL.equals(symbol))
            result += value;
        return result;
    }

    int minus(int result, int value, String symbol) {
        if (MINUS_SYMBOL.equals(symbol))
            result -= value;
        return result;
    }

    int multiply(int result, int value, String symbol) {
        if (MULTIPLY_SYMBOL.equals(symbol))
            result *= value;
        return result;
    }

    int division(int result, int value, String symbol) {
        if (DIVISION_SYMBOL.equals(symbol))
            result /= value;
        return result;
    }

    void printResult(int result) {
        System.out.println(result);
    }

    int calculate() {
        int result = numberElementList.get(0);
        int symbolsIndex = 0;
        for (int numbersIndex = 1; numbersIndex < numberElementList.size(); numbersIndex++) {
            result = plus(result, numberElementList.get(numbersIndex), operationalSymbolElementList.get(symbolsIndex));
            result = minus(result, numberElementList.get(numbersIndex), operationalSymbolElementList.get(symbolsIndex));
            result = multiply(result, numberElementList.get(numbersIndex), operationalSymbolElementList.get(symbolsIndex));
            result = division(result, numberElementList.get(numbersIndex), operationalSymbolElementList.get(symbolsIndex));
            symbolsIndex++;
        }
        return result;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        stringCalculator.prepareForCalculate(stringCalculator);
        stringCalculator.printResult(stringCalculator.calculate());
    }
}

