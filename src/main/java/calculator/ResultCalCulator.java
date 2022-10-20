package calculator;


public class ResultCalCulator {

    public static void main(String[] args) {
        StringAddCalculator calculator = new StringAddCalculator();
        System.out.println("문자열 덧셈 결과입니다 : " + calculator.splitAndSum("1,2,3"));
    }
}
