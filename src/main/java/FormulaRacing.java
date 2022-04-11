import racingcar.Prompt;
import racingcar.RacingController;
import racingcar.Rule;

public class FormulaRacing {
    public static void main(String[] args) {
        int countOfCar = Prompt.ask("레이싱에 참여할 자동차 대수를 입력해주세요.");
        int maxAttempts = Prompt.ask("시도할 횟수는 몇 번인가요?");

        RacingController.start(new Rule(countOfCar, maxAttempts));
    }
}
