package step2;

public class StringCalculator {

    //1. 값을 입력받는다.
    //2. split을 통해 문자열을 자른다.
    //3. 값을 검증한다. (숫자 연산자 숫자 연산자 패턴) <- 연산자는 Enum 또는 상수로 관리해도 좋겠다.
    //4. 값을 검증한다. ("/" 바로 뒤에 0이 오는 경우)
    //5. 값이 제대로 입력되지 않았을 경우 Exception을 도출한다.
    //6. 값이 제대로 입력되었을 경우, 앞에서 부터 계산을 수행한다.

    private static String BLANK = " ";

    static public Double calculate(String str) {

        double result = 0;

        return result;
    }

    static public String[] splitString(String str) {
        return str.split(BLANK);
    }
}
