package study.step2_1;

public class StringCalculator{

    public double calculate(String expression) {

        // 1. 문자열 분리
        String [] values = Separator.separateByDelimiter(expression);

        // 2. 분리된 문자열 중 연산자 , 피연산자 구분
        Calculation calculation = Separator.makeCalculation(values);

        // 3. 연산(계산)
        return  calculation.calculate();
    }

}