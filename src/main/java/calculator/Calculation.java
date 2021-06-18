package calculator;

public class Calculation {
    public int calculation() {
        Input input = new Input();
        Ready ready = new Ready();
        Evaluation evaluation = new Evaluation();
        String[] splitValue = ready.splitMathQuiz(input.mathQuiz());

        for (int i = 1; i < splitValue.length; i += 2) {
            int firstNum = evaluation.convertToNumber(splitValue[i - 1]);
            String operatorValue = splitValue[i];
            int secondNum = evaluation.convertToNumber(splitValue[i + 1]);

            int temp = evaluation.isOperator(firstNum, operatorValue, secondNum);
            splitValue[i + 1] = evaluation.convertToString(temp);
        }

        return evaluation.convertToNumber(splitValue[splitValue.length - 1]);
    }

}
