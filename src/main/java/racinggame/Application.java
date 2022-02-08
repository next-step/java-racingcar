package racinggame;

import java.util.List;
import java.util.stream.Collectors;
import racinggame.domain.Car;
import racinggame.domain.Racing;
import racinggame.domain.Winner;
import racinggame.dto.RacingDTO;
import racinggame.view.InputView;
import racinggame.view.ResultView;

public class Application {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int tryNumber = InputView.getTryNumber();

        Racing game = new Racing();
        game.registerCars(carNames);
        while (tryNumber > 0) {
            game.race();
            List<RacingDTO> result = convertCars(game.getCarInfo());
            ResultView.printRace(result);
            tryNumber--;
        }

        Winner winner = new Winner(game.getCarInfo());
        List<String> winnerNames = winner.getWinnersName();
        ResultView.printWinners(winnerNames);
    }

    private static List<RacingDTO> convertCars(List<Car> cars) {
        return cars.stream()
            .map(RacingDTO::new)
            .collect(Collectors.toList());
    }
}
