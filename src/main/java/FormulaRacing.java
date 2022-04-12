import racingcar.*;

import java.util.List;

public class FormulaRacing {
    public static void main(String[] args) {
        int countOfCar = Prompt.ask("레이싱에 참여할 자동차 대수를 입력해주세요.");
        int maxAttempts = Prompt.ask("시도할 횟수는 몇 번인가요?");

        start(new Rule(countOfCar, maxAttempts));
    }

    private static void start(Rule rule) {
        List<RacingCar> cars = rule.readyCars();

        Printer.print("부릉부릉!! 레이싱 시작");

        Racing racing = new Racing(rule.getMaxAttempts(), cars);
        racing.start();
        racing.cleanUp();

        Printer.print("레이싱 종료");
    }
}
