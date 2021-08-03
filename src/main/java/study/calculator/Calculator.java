package study.calculator;

public class Calculator {


    public static int calculate(String data) {

        String[] dataArray = parseData(data);

        int result = Integer.parseInt(dataArray[0]);

        /**
         * array 의 첫 데이터는 연산자
         * 두 번째 데이터는 연산기호, 세 번째 데이터는 연산자로 계산이 반복된다.
         * loop를 2개씩 넘어가며 전체 계산을 이어갈 수 있도록 한다.
         */
        for (int i = 0; i < dataArray.length - 2; i = i + 2) {
            int firstOperand = result;
            int secondOperand = Integer.parseInt(dataArray[i + 2]);
            String operator = dataArray[i + 1];

            result = ArithmeticOperate(firstOperand, secondOperand, operator);
        }

        return result;
    }


    private static int ArithmeticOperate(int firstOperand, int secondOperand, String operator) {
        CalculatorType calculatorType = CalculatorType.findCalculatorTypeByOperator(operator);

        return calculatorType.calculate(firstOperand, secondOperand);
    }

    private static String[] parseData(String data) {

        if (data == null) {
            throw new IllegalArgumentException("Data는 null 일 수 없습니다.");
        }

        String[] dataArray = data.split(" ");

        return dataArray;
    }
}
