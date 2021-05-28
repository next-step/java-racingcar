package calculator;

public class Calculation {
    public int calculation(String inputValue) {
        Input input = new Input();
        Evaluation evaluation = new Evaluation();
        String[] splitValue = input.isSplit(inputValue);

        for (int i = 1; i < splitValue.length; i += 2) {
            int firstNum = evaluation.convertToNumber(splitValue[i-1]);
            String operatorValue = splitValue[i];
            int secondNum = evaluation.convertToNumber(splitValue[i+1]);

            int temp = evaluation.isOperator(firstNum, operatorValue,secondNum);
            splitValue[i+1] = evaluation.convertToString(temp);
        }

        return evaluation.convertToNumber(splitValue[splitValue.length - 1]);
    }
}
