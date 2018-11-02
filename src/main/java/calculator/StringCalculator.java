package calculator;

public class StringCalculator {
    public static  int calculate(String text){
        String[] values = text.split(" ");

        int result = Integer.parseInt(values[0]);
        for(int i = 1; i < values.length;){
            //1 + 2 + 3
            //3
            //결과 연산자 그다음 숫자
            //result + 3
            int second = Integer.parseInt(values[i+2]);
            String operator = values[i+1];
            result = Calculator(operator,result,second);


        }

    }

    private static int Calculator(String value, int first, int second) {
        if("+".equals(value)){
            return add(first, second);
        }
        if("-".equals(value)){
            return sub(first, second);
        }
        if("*".equals(value)){
            return mul(first, second);
        }
        if("/".equals(value)){
            return div(first, second);
        }

        throw new IllegalArgumentException();
    }

    //string 입력
    //연산자랑 숫자 구분
    // a + b  +  c  a+b b+c

    private static int add(int first, int second) {
        return first + second;
    }

    private static int sub(int first, int second) {
        return first - second;
    }

    private static int mul(int first, int second) {
        return first * second;
    }

    private static int div(int first, int second) {
        return first / second;
    }
}
