package racingcar;

import java.util.List;

public class RacingController {
    public static void start(Rule rule) {
        List<RacingCar> cars = rule.readyCars();

        Printer.print("부릉부릉!! 레이싱 시작");

        Racing racing = new Racing(rule.getMaxAttempts(), cars);
        racing.start();
        racing.end();

        Printer.print("레이싱 종료");
    }
}
