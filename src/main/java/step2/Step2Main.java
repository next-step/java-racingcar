package step2;

import step2.util.StringCalculator;
import step2.util.UserInputUtils;

public class Step2Main {

    public static void main(String[] args) {

        String userInput = UserInputUtils.readUserInput();
        String[] splitUserInputs = UserInputUtils.splitUserInput(userInput);

        int result = StringCalculator.calculate(splitUserInputs);

        System.out.println("결과는 : " + result);

    }

}
