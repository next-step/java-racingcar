package racingStep2;

public class StringCalculator {

    public String execute(String inputData) {

        Validation.nullValueCheck(inputData);

        String[] values = inputData.split(" ");

        int total = Integer.parseInt(values[0]);
        for(int i = 1; i < values.length; i = i + 2) {
            String operation = values[i];
            int iSecondValue = Integer.parseInt(values[i+1]);

            total = calculation(total, iSecondValue, operation);

        }

        return Integer.toString(total);
    }

    private int calculation(int value1, int value2, String operation) {

        switch (operation) {
            case "+" :
                return Calculate.add(value1, value2);
            case "-" :
                return Calculate.subtract(value1, value2);
            case "*" :
                return Calculate.multiply(value1, value2);
            case "/" :
                return Calculate.divide(value1, value2);
            default:
                throw new IllegalArgumentException("해당 연산 기호는 사칙연산을 지원하지 않습니다!!!!");
        }
    }
}
