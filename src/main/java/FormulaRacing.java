import racingcar.Printer;
import racingcar.Prompt;
import racingcar.RacingCars;
import racingcar.Rule;

public class FormulaRacing {
    public static void main(String[] args) {
        String[] carNames = Prompt.ask("레이싱에 참여할 자동차를 쉼표(,)를 기준으로 입력해주세요.");
        int maxAttempts = Prompt.askAttempt("시도할 횟수는 몇 번인가요?");
        RacingCars cars = new RacingCars(carNames);

        race(new Rule(cars, maxAttempts));
    }

    private static void race(Rule rule) {
        Printer.println("부릉부릉!! 레이싱 시작");
        RacingCars cars = rule.getCars();

        for (int attempt = 0; attempt < rule.getMaxAttempts(); attempt++) {
            cars.turnAroundCircuit();
            Printer.print(cars);
            Printer.println((attempt + 1) + "회차 종료");
        }

        String winners = cars.award();
        Printer.award(winners);
        Printer.println("레이싱 종료");
    }
}
