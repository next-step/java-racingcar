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

    String inputString;
    String[] elementStringArray;
    List<String> numberStringElementList;
    List<Integer> numberElementList;
    List<String> operationalSymbolElementList;
    int result;

    public StringCalculator(String inputString) {
        this.inputString = inputString;
    }

    void validateInputString() throws IllegalArgumentException {
        if (inputString == null
                || inputString.isEmpty()
                || inputString.replaceAll(StringCalculator.SEPARATOR_STRING,
                StringCalculator.EMPTY_STRING).isEmpty()) {
            throw new IllegalArgumentException("입력값은 null, 빈 문자열, 공백 문자열로만 이루어진 것을 허용하지 않습니다!");
        }
    }

    void splitInputString() {
        elementStringArray = inputString.split(StringCalculator.SEPARATOR_STRING);
    }

    void validateElementStringArrayLength() throws IllegalArgumentException {
        if (elementStringArray.length < StringCalculator.MIN_ELEMENT_STRING_ARRAY_LENGTH) {
            throw new IllegalArgumentException("입력값은 최소 계산 할 두개의 숫자와 하나의 사칙연산 기호로 이루어져야 합니다.");
        }
        if (elementStringArray.length % 2 != 1) {
            throw new IllegalArgumentException("입력값은 계산할 숫자문자열과 사칙연산기호 문자열의 개수를 더 했을 때 홀수로 이루어져야 합니다.");
        }
    }

    void validateElementStringArrayFirstValueAndLastValue() {
        validateNumberStringValue(elementStringArray[0]);
        validateNumberStringValue(elementStringArray[elementStringArray.length - 1]);
    }

    void validateNumberStringValue(String stringValue) throws IllegalArgumentException {
        if (!Pattern.matches(StringCalculator.NUMBER_REGEX, stringValue)) {
            throw new IllegalArgumentException("숫자형태 문자열이 와야 할 자리에 다른형태 문자열이 있습니다.");
        }
    }

    void validateOperationalSymbolStringValue(String stringValue) throws IllegalArgumentException {
        if (!StringCalculator.PLUS_SYMBOL.equals(stringValue)
                && !StringCalculator.MINUS_SYMBOL.equals(stringValue)
                && !StringCalculator.MULTIPLY_SYMBOL.equals(stringValue)
                && !StringCalculator.DIVISION_SYMBOL.equals(stringValue))
            throw new IllegalArgumentException("사칙연산기호 문자열이 와야 할 자리에 다른형태 문자열이 있습니다.");
    }

    void setNumberStringElementList() {
        numberStringElementList = new ArrayList();
        for (int index = 0; index < elementStringArray.length; index += 2) {
            numberStringElementList.add(elementStringArray[index]);
        }
    }

    void setOperationalSymbolElementList() {
        operationalSymbolElementList = new ArrayList();
        for (int index = 1; index < elementStringArray.length; index += 2) {
            operationalSymbolElementList.add(elementStringArray[index]);
        }
    }

    void validateNumberStringElementListValues() {
        for (String numberString : numberStringElementList) {
            validateNumberStringValue(numberString);
        }
    }

    void validateOperationalSymbolElementListValues() throws IllegalArgumentException {
        for (String operationalSymbolString : operationalSymbolElementList) {
            validateOperationalSymbolStringValue(operationalSymbolString);
        }
    }

    void setNumberElementList() {
        numberElementList = new ArrayList<>();
        for (String numberString : numberStringElementList) {
            numberElementList.add(Integer.parseInt(numberString));
        }
    }

    void prepareForCalculate(StringCalculator stringCalculator) {
        // 입력 문자열 null or empty string or white space string validation check
        stringCalculator.validateInputString();
        // 입력 문자열 split
        stringCalculator.splitInputString();
        // 쪼갠 문자열 요소 배열길이 validation check
        stringCalculator.validateElementStringArrayLength();
        // 조갠 문자열 요소 배열의 첫번째 value, 마지막 value validation check
        stringCalculator.validateElementStringArrayFirstValueAndLastValue();
        // 문자열 요소 배열의 인덱스가 0 포함 짝수인 값들만 사직연산 기호 문자열 리스트에 담는다.
        stringCalculator.setNumberStringElementList();
        // 문자열 요소 배열의 인덱스가 홀수인 값들만 사직연산 기호 문자열 리스트에 담는다.
        stringCalculator.setOperationalSymbolElementList();
        // 문자열 요소 배열의 인덱스가 짝수 번째 문자열은 숫자형태로만 이루어져야 한다.
        stringCalculator.validateNumberStringElementListValues();
        // 문자열 요소 배열의 인덱스가 홀수 번째 문자열은 사칙연산 기호로만 이루어져야 한다.
        stringCalculator.validateOperationalSymbolElementListValues();
        // 숫자형태 문자열 리스트 value를 Integer로 parse 후 numberElementList add
        stringCalculator.setNumberElementList();
    }

    void plus(int value, String symbol) {
        if (StringCalculator.PLUS_SYMBOL.equals(symbol))
            result += value;
    }

    void minus(int value, String symbol) {
        if (StringCalculator.MINUS_SYMBOL.equals(symbol))
            result -= value;
    }

    void multiply(int value, String symbol) {
        if (StringCalculator.MULTIPLY_SYMBOL.equals(symbol))
            result *= value;
    }

    void division(int value, String symbol) {
        if (StringCalculator.DIVISION_SYMBOL.equals(symbol))
            result /= value;
    }

    void printResult() {
        System.out.println(result);
    }

    void calculate() {
        result = numberElementList.get(0);
        int symbolsIndex = 0;
        for (int numbersIndex = 1; numbersIndex < numberElementList.size(); numbersIndex++) {
            plus(numberElementList.get(numbersIndex), operationalSymbolElementList.get(symbolsIndex));
            minus(numberElementList.get(numbersIndex), operationalSymbolElementList.get(symbolsIndex));
            multiply(numberElementList.get(numbersIndex), operationalSymbolElementList.get(symbolsIndex));
            division(numberElementList.get(numbersIndex), operationalSymbolElementList.get(symbolsIndex));
            symbolsIndex++;
        }
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        stringCalculator.prepareForCalculate(stringCalculator);
        stringCalculator.calculate();
        stringCalculator.printResult();
    }
}

