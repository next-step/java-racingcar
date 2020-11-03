package racingGame.View;

import racingGame.GameSetting;

import java.util.Scanner;

public class InputView {

    static final String NUM_CAR_QUESTION = "자동차 댓수는 몇 대 인가요?";
    static final String NUM_ROUND_QUESTION = "시도할 횟수는 몇 회 인가요?";

    Scanner scanner;

    private InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static InputView createInstance(){
        return new InputView(new Scanner(System.in));
    }

    public GameSetting setUpGame() {
        int numRound;
        int numCar;

        System.out.println(NUM_CAR_QUESTION);
        numRound = this.scanner.nextInt();

        System.out.println(NUM_ROUND_QUESTION);
        numCar = this.scanner.nextInt();

        return GameSetting.of(numRound, numCar);
    }

}
