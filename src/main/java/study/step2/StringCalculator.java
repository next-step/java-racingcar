package study.step2;

public class StringCalculator implements Calculator {

    @Override
    public String cal(String input) {

        return add(input);
    }

    private String add(String input) {
        String result1 = input.split("[+]")[0].trim();
        String result2 = input.split("[+]")[1].trim();

        return String.valueOf(Operator.ADD.apply(result1, result2));
    }



}
