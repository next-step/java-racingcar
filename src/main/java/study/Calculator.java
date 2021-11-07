package study;

public class Calculator {
    public static int calculate(String param) {
        String[] values = param.split(" ");
        int first = Integer.parseInt(values[0]);
        String operator = values[1];
        int second = Integer.parseInt(values[2]);

        return extracted(first, operator, second);
    }

    private static int extracted(int first, String operator, int second) {
        if(operator.equals("+")){
            return first + second;
        }
        if(operator.equals("-")) {
            return first - second;
        }
        if(operator.equals("*")) {
            return first * second;
        }
        if(operator.equals("/")){
            valid(second);
            return first / second;
        }
        return 0;
    }

    public static int calculate2(String param) {
        String[] values = param.split(" ");
        MyNumber first = new MyNumber(values[0]);
        MyNumber second = new MyNumber(values[2]);
        String operator = values[1];

        return calculate2(first, operator, second).getNumber();
    }

    private static MyNumber calculate2(MyNumber first, String operator, MyNumber second) {
        if(operator.equals("+")){
            return first.plus(second);
        }
        if(operator.equals("-")) {
            return first.minus(second);
        }
        if(operator.equals("*")) {
            return first.times(second);
        }
        if(operator.equals("/")){
//            valid(second);
            return first.dividedBy(second);
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }

    private static void valid(int second) {
        if(second == 0){
            throw new IllegalArgumentException("분모가 0일 될 수 없습니다.");
        }
    }
}
