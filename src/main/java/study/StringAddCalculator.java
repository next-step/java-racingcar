package study;

import javafx.css.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final StringAddCalculator instance = new StringAddCalculator();
    public static int ZERO = 0;
    public static String COMMA = ",";
    public static String COLON = ":";

    public int splitAndSum(String input) {

        int result = ZERO;

        // 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.
        if(_checkValidNull(input)) {
            return result;
        }

        // 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.

        if(_isNumeric(input)) {
            result = _parseInt(input);
        }


        // 3. 숫자 두개를 컴마(,)구분자로 입력할 경우 두 숫자의 합을 반환한다.
        // 4. 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.
        if(_containsCharacter(input, COMMA) || _containsCharacter(input, COLON)) {
            result =_sumNumbericSplitByCommaOrColon(input);
        }

        // 5. "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다.

        Matcher m = _containsCharacter(input);
        if(m != null) {
            result = _sumNumbericSplitByCharacter(input, m);
        }

        return result;

    }

    private void _checkMinusNumeric(int input) {
        if(input < 0) {
            throw new RuntimeException();
        }

    }
    private boolean _checkValidNull(String input) {
        if(input == null ) {
            return true;
        }
        if(input.isEmpty()) {
            return true;
        }
        return false;
    }

    private int _parseInt(String input){

        int inputInteger = ZERO;
        if(!_isNumeric(input)) {
            return inputInteger;
        }

        inputInteger = Integer.parseInt(input);

        /**
         *  6. 음수 체크
         * */
        _checkMinusNumeric(inputInteger);

        return inputInteger;
    }

    private boolean _isNumeric(String input) {
        return Pattern.matches("-?\\d+", input);
    }

    private boolean _containsCharacter(String input, String Character) {
        // 문자열에 컴마가 포함되어 있는지 확인
        if(COMMA.equals(Character)) {
            return input.contains(COMMA);
        } else if(COLON.equals(Character)) {
            return input.contains(COLON);
        }
        return false;
    }

    private int _sumNumbericSplitByCommaOrColon(String input) {
        int sumResult = 0;
        String[] numbers = input.split(COMMA);
        for(String number : numbers) {
            if (_isNumeric(number)) {
                sumResult += _parseInt(number);
            } else {
                if(_containsCharacter(number, COLON)) {
                    String[] numbersColon = number.split(COLON);
                    for(String numberColon : numbersColon) {
                        sumResult += _parseInt(numberColon);
                    }
                }
            }
        }

        return sumResult;
    }

    private Matcher _containsCharacter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            return m;
        } else {
            return null;
        }
    }
    private int _sumNumbericSplitByCharacter(String input, Matcher m) {
        int sumResult = 0;

        String customDelimiter = m.group(1);
        String[] tokens= m.group(2).split(customDelimiter);
        for(String token : tokens) {
            sumResult += _parseInt(token);
        }

        return sumResult;
    }

    public static StringAddCalculator getInstance() {
        return instance;
    }
}
