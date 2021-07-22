package stringcalculator;

import stringcalculator.util.OperationUtil;
import stringcalculator.util.UserInputUtils;

public class StringCalculator {

    public static void main(String[] args) {

        String userInput = UserInputUtils.readUserInput();
        String[] UserInputArray = UserInputUtils.splitUserInput(userInput);

        int result = OperationUtil.calculate(UserInputArray);

        System.out.println("결과는 : " + result);

    }

}
