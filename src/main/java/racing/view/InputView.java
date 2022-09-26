package racing.view;

import racing.util.CustomUserInputHandler;

public class InputView {
    private InputView(){

    }
    public static int getCarCount(){
        return makeQuestion("자동차 대수는 몇 대 인가요?");
    }

    public static int getGameCount(){
        return makeQuestion("시도할 회수는 몇 회 인가요?");
    }

    public static int makeQuestion(String message) {
        System.out.println(message);
        String userInput = CustomUserInputHandler.scan();

        int result = CustomUserInputHandler.parseInt(userInput);
        if (CustomUserInputHandler.validate(result)) {
            return result;
        }

        return makeQuestion(message);
    }
}
