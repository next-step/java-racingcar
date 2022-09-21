import racingcar.RacingCarList;
import racingcar.model.InputView;
import racingcar.model.ResultView;

public class Main {
    public static void main(String[] args) {
        InputView input = InputView.scan();

        RacingCarList racingCars = RacingCarList.initialize(input.carCount());

        System.out.println("실행 결과");
        for (int i = 0; i < input.tryCount(); i++) {
            racingCars = racingCars.next();

            ResultView.print(racingCars);
        }
    }
}
