package step4.view;

import step4.model.Race;
import step4.model.RacingCars;
import step4.model.SplitStrategy;

import java.util.Scanner;

public class InputView {

    private final SplitStrategy splitStrategy;
    private final Scanner scanner;

    private static String START_RACE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private static String HOW_MANY_TRY = "시도할 회수는 몇회인가요?";

    public InputView(SplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
        this.scanner = new Scanner(System.in);
    }

    public Race getInput() {
        System.out.println(START_RACE);
        String inputCarNames = scanner.nextLine();
        System.out.println(HOW_MANY_TRY);
        int tryNumbers = scanner.nextInt();
        String[] carNames = splitStrategy.split(inputCarNames);

        return Race.of(RacingCars.createRacingCars(carNames), tryNumbers);
    }
}
