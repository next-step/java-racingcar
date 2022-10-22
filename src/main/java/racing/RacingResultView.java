package racing;

import java.util.List;

public class RacingResultView {
    public static void makeRacingResult(int gameCount, List<Car> carList) {
        System.out.print("실행결과");
        for (int i = 0; i < gameCount; i++) {
            for (Car car : carList) {
                car.move();
                System.out.println();
                car.printResult();
            }
            System.out.println();
        }

        System.out.println();
    }
}
