package racing.view;

import racing.util.CustomUserInputHandler;

public class InputView {

    public static int makeQuestion(String message) {
        System.out.println(message);
        String userInput = CustomUserInputHandler.scan();

        int result = CustomUserInputHandler.parseInt(userInput);
        if(CustomUserInputHandler.validate(result)){
            return result;
        }

        return makeQuestion(message);
    }
}
