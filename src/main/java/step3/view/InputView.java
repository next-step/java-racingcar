package step3.view;

import step3.util.UserInput;

public class InputView {

    public static int askNumberOfCars() {
        return askNumericInput("자동차 대수는 몇 대 인가요?");
    }

    public static int askNumberOfRounds() {
        return askNumericInput("시도할 회수는 몇 회 인가요?");
    }

    private static int askNumericInput(String question) {
        System.out.println(question);
        return UserInput.getInt();
    }

}
