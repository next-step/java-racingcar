package racing.view;

import racing.util.UserInputHandler;
import racing.util.UserIntegerInputHandler;
import racing.util.UserStringInputHandler;

public class InputView {
    private InputView() {

    }

    public static int getGameCount() {
        return Integer.parseInt(getUserInput("시도할 회수는 몇 회 인가요?", new UserIntegerInputHandler()));
    }
    public static String[] getCarNames() {
        UserStringInputHandler userStringInputHandler = new UserStringInputHandler();
        return UserStringInputHandler.split(getUserInput("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", userStringInputHandler));
    }

    public static String getUserInput(String message, UserInputHandler handler) {
        System.out.println(message);
        String userInput = handler.scan();
        if (handler.validate(userInput)) {
            return userInput;
        }
        return getUserInput(message, handler);
    }
}
