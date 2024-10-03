package racingcar.controller;

import java.util.Scanner;
import java.util.logging.Logger;

public class InputView {

    private static final Logger logger = Logger.getLogger(InputView.class.getName());
    public static final Scanner scanner = new Scanner(System.in);
    private static InputView INSTANCE = null;

    private InputView() {

    }

    public static InputView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new InputView();
        }
        return INSTANCE;
    }

    public int getCarNumber() {
        logger.info("자동차 대수는 몇 대 인가요?");
        return scanner.nextInt();

    }

    public int getMatchNumber() {
        logger.info("시도할 회수는 몇 회 인가요?");
        return scanner.nextInt();
    }
}
