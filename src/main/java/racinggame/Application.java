package racinggame;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.domain.Car;
import racinggame.domain.Racing;
import racinggame.dto.RacingDTO;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();

        Racing game = Racing.fromCarNames(carNames);
        while (tryNumber > 0) {
            List<RacingDTO> result = convertCars(game.race());
            ResultView.printRace(result);
            tryNumber--;
        }

        ResultView.printWinners(game.getWinnersName());
    }

    private static List<RacingDTO> convertCars(List<Car> cars) {
        return cars.stream()
            .map(RacingDTO::from)
            .collect(Collectors.toList());
    }
}
