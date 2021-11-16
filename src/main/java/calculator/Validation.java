package calculator;

public class Validation {

    //입력된 문자가 빈값이거나 NULL 인지 확인
    public static void nullValueCheck(String inputData) {

        if(inputData.trim().isEmpty() || inputData == null) {
            throw new IllegalArgumentException("빈 값과 NULL은 입력 하실 수 없습니다!!!!!");
        }
    }

    //나눗셈의 결과가 정수인지 확인
    public static void validDivide(int value1, int value2) {
        if(value1 % value2 != 0) {
            throw new IllegalArgumentException("정수 나눗셈만 가능합니다!!!!");
        }
    }
}
