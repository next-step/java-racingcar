package racing;

import java.util.Random;

public class ResultView extends View<Void, RacingData> {
    private final Random random;

    public ResultView() {
        random = new Random();
    }

    @Override
    public Void show(RacingData data) {
        System.out.println("실행 결과");

        for (int i = 0; i < data.getAttemptsCount(); i++) {
            for (Driver driver : data.getDrivers()) {
                driver.drive(() -> random.nextInt(10));
                driver.printCurrentDistance();
            }
            System.out.println();
        }

        return null;
    }
}
