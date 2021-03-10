package step2;

public class Calculate {
    public int calculateFormula(String[] formulaList) {
        int result = 0;

        int number1 = Integer.parseInt(formulaList[0]);

        for (int i = 1; i < formulaList.length; i+=2) {
            int number2 = Integer.parseInt(formulaList[i + 1]);

            result = OperationEnum.getOperationEnum(formulaList[i]).operation(number1, number2);

            number1 = result;
        }

        return result;
    }

}
