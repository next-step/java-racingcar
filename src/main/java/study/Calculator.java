package study;

public class Calculator {
    public static int calculate(String param) {
        String[] values = validation(param);

        MyNumber result = new MyNumber(values[0]);
        for(int i = 1; i < values.length; i = i + 2){
            result = calculate(result, values[i], new MyNumber(values[i+1]));
        }
        return result.getNumber();
    }

    /**
     * 입력값 정상 여부 확인
     * @param param
     * @return
     */
    private static String[] validation(String param) {
        if(param == null || param.isEmpty()){
            throw new IllegalArgumentException("입력 문자열이 정상적이지 않습니다.");
        }
        String[] values = param.split(" ");
        if(values.length < 3 || values.length % 2 == 0){
            throw new IllegalArgumentException("입력 문자열이 정상적이지 않습니다.");
        }
        return values;
    }

    /**
     * 사칙연산 계산
     * @param first
     * @param operator
     * @param second
     * @return
     */
    private static MyNumber calculate(MyNumber first, String operator, MyNumber second) {
        return MyOperator.operator(operator).operate(first, second);
    }

}
