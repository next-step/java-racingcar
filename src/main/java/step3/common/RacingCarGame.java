package step3.common;

import step3.common.util.PrintUtils;
import step3.common.view.InputView;

public class RacingCarGame implements Game {

    private int carNumber;
    private int moveNumber;

    private static final String INPUT_CAR_NUMBER_TEXT = "자동차 대수는 몇 대 인가요?";
    private static final String INPUT_MOVE_NUMBER_TEXT = "시도할 회수는 몇 회 인가요?";

    @Override
    public void start() {

        PrintUtils.println(INPUT_CAR_NUMBER_TEXT);
        carNumber = InputView.input();
        PrintUtils.println(INPUT_MOVE_NUMBER_TEXT);
        moveNumber = InputView.input();

    }

}
