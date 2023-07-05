package racingcar;

public class RacingGameRunner {

    private final String CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String COUNT = "시도할 회수는 몇회인가요?";
    private final String PLAY_RESULT = "\n실행 결과";

    private final Input input = new ConsoleInput();
    private final Output output = new ConsoleOutput();

    public void run() {
        output.print(CAR_NAMES);
        String carNames = input.read();

        output.print(COUNT);
        String count = input.read();

        RacingGame racingGame = new RacingGame(new Cars(carNames), count);

        output.print(PLAY_RESULT);
        output.print(racingGame.play());
    }
}
