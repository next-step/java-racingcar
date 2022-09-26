package game.view;

import game.controller.dto.GameParam;

import java.util.Scanner;

public class InputView {

    private static final String QUESTION_FOR_CAR_NUM = "자동차 대수는 몇 대 인가요?";
    private static final String QUESTION_FOR_TRY_NUM = "시도할 횟수는 몇 회 인가요?";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static GameParam getGameParam() {
        System.out.println(QUESTION_FOR_CAR_NUM);
        int carNumber = inputNum();
        System.out.println(QUESTION_FOR_TRY_NUM);
        int tryNumber = inputNum();
        return new GameParam(carNumber, tryNumber);
    }

    private static int inputNum() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
