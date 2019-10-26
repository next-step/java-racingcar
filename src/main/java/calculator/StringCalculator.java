package calculator;

public class StringCalculator {

    public int calculator(String value) {
        if(value == null || value  == "") {
            throw new IllegalArgumentException("입력된 값이 없습니다. 다시 입력해주세요.");
        }
        String values[] = value.split("\\s");
        int right = 0;
        String operator =  null;
        int sum = Integer.parseInt(values[0]);

        for (Integer i=1; i < values.length; i+=2) {
            right = Integer.parseInt(values[i+1]);
            operator = values[i];
            sum = compute(operator, sum, right);
        }
        return sum;
    }

    public Integer compute(String operator, int left, int right) {
        Calculator calculator = new CalculatorFactory().createCalculator(operator);

        return calculator.calculator(left, right);
    }
}
