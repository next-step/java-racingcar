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

    private String inputStr;
    private List<Integer> numbers;
    private List<String> operationalSymbols;

    public StringCalculator(String inputStr) {
        this.inputStr = inputStr;
    }

    public static void main(String[] args) {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");
        stringCalculator.prepareForCalculate(stringCalculator);
        stringCalculator.printResult(stringCalculator.calculate());
    }

    void checkInputEmpty() throws IllegalArgumentException {
        if (inputStr == null
                || inputStr.isEmpty()
                || inputStr.replaceAll(SEPARATOR_STRING, EMPTY_STRING).isEmpty()) {
            throw new IllegalArgumentException("입력값은 null, 빈 문자열, 공백 문자열로만 이루어진 것을 허용하지 않습니다!");
        }
    }

    void checkMinLength(String[] strArr) throws IllegalArgumentException {
        if (strArr.length < MIN_ELEMENT_STRING_ARRAY_LENGTH) {
            throw new IllegalArgumentException("입력값은 최소 계산 할 두개의 숫자와 하나의 사칙연산 기호로 이루어져야 합니다.");
        }
    }

    void checkOddLength(String[] strArr) throws IllegalArgumentException {
        if (strArr.length % 2 == 0) {
            throw new IllegalArgumentException("입력값은 최소 계산 할 두개의 숫자와 하나의 사칙연산 기호로 이루어져야 합니다.");
        }
    }

    void checkFirstAndLastNumberValues(String[] strArr) {
        checkNumberString(strArr[0]);
        checkNumberString(strArr[strArr.length - 1]);
    }

    void validationInputStrings(String[] strArr) {
        checkMinLength(strArr);
        checkOddLength(strArr);
        checkFirstAndLastNumberValues(strArr);
    }

    void checkNumberString(String strValue) throws IllegalArgumentException {
        if (!Pattern.matches(NUMBER_REGEX, strValue)) {
            throw new IllegalArgumentException("숫자형태 문자열이 와야 할 자리에 다른형태 문자열이 있습니다.");
        }
    }

    void checkOperationalSymbol(String strValue) throws IllegalArgumentException {
        if (!PLUS_SYMBOL.equals(strValue)
                && !MINUS_SYMBOL.equals(strValue)
                && !MULTIPLY_SYMBOL.equals(strValue)
                && !DIVISION_SYMBOL.equals(strValue))
            throw new IllegalArgumentException("사칙연산기호 문자열이 와야 할 자리에 다른형태 문자열이 있습니다.");
    }

    void checkNumbers(List<String> numberStrings) {
        for (String numberString : numberStrings) {
            checkNumberString(numberString);
        }
    }

    void checkOperationalSymbols() throws IllegalArgumentException {
        for (String operationalSymbol: operationalSymbols) {
            checkOperationalSymbol(operationalSymbol);
        }
    }

    String[] splitInput() {
        return inputStr.split(SEPARATOR_STRING);
    }

    List<String> getNumerStrings(String[] strArr) {
        List<String> numberStrings = new ArrayList();
        for (int index = 0; index < strArr.length; index += 2) {
            numberStrings.add(strArr[index]);
        }
        return numberStrings;
    }

    void setOperationalSymbols(String[] strArr) {
        operationalSymbols = new ArrayList();
        for (int index = 1; index < strArr.length; index += 2) {
            operationalSymbols.add(strArr[index]);
        }
    }

    void setNumbers(List<String> numberStrings) {
        numbers = new ArrayList<>();
        for (String numberString : numberStrings) {
            numbers.add(Integer.parseInt(numberString));
        }
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

    void prepareForCalculate(StringCalculator strCal) {
        strCal.checkInputEmpty();
        String[] strArr = strCal.splitInput();
        validationInputStrings(strArr);
        strCal.setOperationalSymbols(strArr);
        strCal.checkOperationalSymbols();
        List<String> numberStrings = strCal.getNumerStrings(strArr);
        strCal.checkNumbers(numberStrings);
        strCal.setNumbers(numberStrings);
    }

    int calculate() {
        int result = numbers.get(0);
        int symbolsIndex = 0;
        for (int numbersIndex = 1; numbersIndex < numbers.size(); numbersIndex++) {
            result = plus(result, numbers.get(numbersIndex), operationalSymbols.get(symbolsIndex));
            result = minus(result, numbers.get(numbersIndex), operationalSymbols.get(symbolsIndex));
            result = multiply(result, numbers.get(numbersIndex), operationalSymbols.get(symbolsIndex));
            result = division(result, numbers.get(numbersIndex), operationalSymbols.get(symbolsIndex));
            symbolsIndex++;
        }
        return result;
    }

    void printResult(int result) {
        System.out.println(result);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<String> getOperationalSymbols() {
        return operationalSymbols;
    }
}

