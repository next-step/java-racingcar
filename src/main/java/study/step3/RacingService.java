package study.step3;

import study.step3.ui.InputView;
import study.step3.utils.Printer;

public class RacingService {
    public String MESSAGE_INPUT_CAR = "자동차 대수는 몇 대 인가요?";
    public String MESSAGE_INPUT_ROUND = "시도할 회수는 몇 회 인가요?";
    public String MESSAGE_RACING_START = "자동차 경주를 시작합니다.";
    public String MESSAGE_ROUND = "라운드";
    public String PRINT_TOKEN = "-";

    public RacingService() {
    }

    public void play() {
        int carCount = InputView.inputCount(MESSAGE_INPUT_CAR);
        int round = InputView.inputCount(MESSAGE_INPUT_ROUND);

        Racing racing = new Racing();
        racing.setUp(carCount);

        Printer.println(MESSAGE_RACING_START);
        for(int i=0; i<round; i++) {
            Printer.println((i+1) + MESSAGE_ROUND);
            racing.run();
            racing.printRacingResult(PRINT_TOKEN);
        }
    }
}
