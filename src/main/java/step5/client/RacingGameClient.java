package step5.client;

import step5.client.view.output.Printer;
import step5.client.worker.interfaces.controller.RacingGameController;

import static step5.client.view.input.InputView.questionAndAnswer;

public class RacingGameClient {
    private static final String ENTER_THE_NAME_OF_THE_CARS = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String HOW_MUCH_ATTEMPT_QUESTION = "시도할 회수는 몇 회 인가요?";
    private static final RacingGameController controller = new RacingGameController();

    public static void main(String[] args) {
        final String carNames = questionAndAnswer(ENTER_THE_NAME_OF_THE_CARS);
        final String times = questionAndAnswer(HOW_MUCH_ATTEMPT_QUESTION);
        final String result = controller.showRacingGameResultView(carNames, times);
        Printer.print(result);
    }
}
