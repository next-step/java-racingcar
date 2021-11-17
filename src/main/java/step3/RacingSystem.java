package step3;

import java.util.Scanner;

public class RacingSystem {

    private RacingCount racingCount;
    private CarGroup carGroup;

    public RacingSystem() {
        try (Scanner scanner = new Scanner(System.in)) {
            InputView inputView = new InputView(scanner);
            this.carGroup = new CarGroup(inputView.askCarName());
            this.racingCount = new RacingCount(inputView.askRacingCount());
        }
    }

    public void racingStart() {
        for (int i = 0; i < racingCount.count; i++) {
            ResultView.result(carGroup.racing());
        }
        racingResult();
    }

    private void racingResult() {
        ResultView.finalResult(carGroup.getFarthestCarNames());
    }

    public static void main(String[] args) {
        new RacingSystem().racingStart();
    }
}
