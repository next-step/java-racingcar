package step3;

import java.util.Scanner;

public class RacingSystem {

    private CarCount carCount;
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
            carGroup.racing();
        }
    }

    public static void main(String[] args) {
        new RacingSystem().racingStart();
    }
}
