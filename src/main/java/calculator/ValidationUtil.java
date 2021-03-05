package calculator;

public class ValidationUtil {

    private  ValidationUtil() {};
    public static void validateInput(String[] input) {
        try {
            validateInputNull(input);
            validateInputSize(input.length);
            validateAppropriateOperator(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     *  @param String size String 배열의 크기 값
     *  배열의 크기 값이 3보다 작거나 홀수가 아니면 Exception 발생
     * */
    public static void validateInputSize(int size){
        if(size <= 3 && size % 2 != 1){
            throw new IllegalArgumentException("입력 값의 크기가 값이 3보다 작거나 값과 연산자 사이 띄어쓰기를 확인해주세요.");
        }
    }
    /*
     *  @param String size String 배열의 값
     *  연산자(+,-,*,/)가 아닌 문자열이 나올 경우 IllegalArgumentException 발생
     * */
    public static void validateAppropriateOperator(String[] inputArray) throws IllegalArgumentException {
        for (int i = 1; i < inputArray.length; i += 2) {
            Operator.converterOperator(inputArray[i]);
        }
    }
    /*
     *  @param String size String 배열의 값
     *  입력값이 Null일때 NullPointerException 발생
     * */
    public static void validateInputNull(String[] inputArray) throws NullPointerException{
        if(inputArray[0].equalsIgnoreCase("")){
            throw new IllegalArgumentException("연산자의 값이 비어있습니다. 다시한번 확인해주세요");
        }

    }

}
