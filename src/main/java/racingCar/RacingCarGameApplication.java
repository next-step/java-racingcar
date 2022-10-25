package racingCar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameApplication {

    public static void main(String[] args) {
        InputView keyboardInput = InputView.getInputView();
        ResultView printer = new ResultView();

        RacingCars cars = new RacingCars(keyboardInput.nameOfCars());
        int numberOfRounds = keyboardInput.numberOfRounds();
        RacingGame game = new RacingGame(cars, numberOfRounds);

        game.start();

        printer.print("실행 결과");
        printer.print(cars);

        List<String> winners = new RacingWinnerCalculator(cars).winners()
                .stream()
                .map(RacingCar::name)
                .collect(Collectors.toList());
        printer.print(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}