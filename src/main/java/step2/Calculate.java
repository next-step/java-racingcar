package step2;

public class Calculate {

    private int sumCalculate(int a, int b) {
        return a + b;
    }

    private int minusCalculate(int a, int b) {
        return a - b;
    }

    private int multiplyCalculate(int a, int b) {
        return a * b;
    }

    private int divideCalculate(int a, int b) {
        return a / b;
    }


    public int calculateFormula(String[] formulaList) {
        int result = 0;

        int number1 = Integer.parseInt(formulaList[0]);

        for (int i = 1; i < formulaList.length; i+=2) {
            int number2 = Integer.parseInt(formulaList[i + 1]);

            switch (formulaList[i]) {
                case "+":
                    result = sumCalculate(number1, number2);
                    break;
                case "-":
                    result = minusCalculate(number1, number2);
                    break;
                case "*":
                    result = multiplyCalculate(number1, number2);
                    break;
                case "/":
                    result = divideCalculate(number1, number2);
                    break;
            }

            number1 = result;
        }

        return result;
    }

}
