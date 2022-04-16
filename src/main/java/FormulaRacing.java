import racingcar.*;

public class FormulaRacing {
    public static void main(String[] args) {
        String[] carNames = Prompt.ask("레이싱에 참여할 자동차를 쉼표(,)를 기준으로 입력해주세요.");
        int maxAttempts = Prompt.askAttempt("시도할 횟수는 몇 번인가요?");
        RacingCars cars = new RacingCars(carNames);

        start(new Rule(cars, maxAttempts));
    }

    private static void start(Rule rule) {
        Printer.println("부릉부릉!! 레이싱 시작");

        // 레이싱의 역할을 축소해서 cars에게 한바퀴 돌라고 역할주기?
        Racing racing = new Racing(rule.getMaxAttempts(), rule.getCars());
        racing.start();

        Printer.println("레이싱 종료");
    }
}
