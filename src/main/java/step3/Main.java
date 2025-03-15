package step3;


import step3.random.DefaultRandomStrategy;
import step3.util.InputView;

public class Main {
    private static final String CAR_COUNT_MESSAGE = "자동차 대수는 몇 대 인가요?";
    private static final String MOVE_COUNT_MESSAGE = "시도할 회수는 몇 회 인가요?";
    public static void main(String[] args) {
        int carCount = InputView.inputInt(CAR_COUNT_MESSAGE);
        int moveCount = InputView.inputInt(MOVE_COUNT_MESSAGE);
        RacingGame game = new RacingGame(carCount, moveCount, new DefaultRandomStrategy());
        System.out.print("\n실행 결과");
        System.out.println(game.start());
    }
}