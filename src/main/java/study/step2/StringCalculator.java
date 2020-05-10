package study.step2;

public class StringCalculator implements Calculator {

    @Override
    public String cal(String input) {
        return Operatoration.calculate(input);
    }

}
