package study.step4;

import study.step4.ui.InputView;

public class RacingService {
    public String MESSAGE_INPUT_ROUND = "시도할 회수는 몇 회 인가요?";
    public String MESSAGE_RACING_START = "자동차 경주를 시작합니다.";
    public String MESSAGE_ROUND = "라운드";
    public String PRINT_TOKEN = "-";

    private String MESSAGE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private String MESSAGE_PRINT_WINNER = "가 최종 우승하였습니다.";

    public RacingService() {
    }

    public void play() {
        String[] carNames = InputView.inputCarNames(MESSAGE_INPUT_CAR_NAMES);
        int round = InputView.inputCount(MESSAGE_INPUT_ROUND);

        Racing racing = new Racing();
        racing.setUp(carNames);

        System.out.println(MESSAGE_RACING_START);
        for(int i=0; i<round; i++) {
            System.out.println("\n" + (i+1) + MESSAGE_ROUND);
            racing.run();
            racing.printRacingResult(PRINT_TOKEN);
        }
        System.out.println("\n");
        racing.printRacingWinner(MESSAGE_PRINT_WINNER);
    }
}
