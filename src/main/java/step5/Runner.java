package step5;

import step5.domain.Car;
import step5.domain.CarRacingGame;
import step5.domain.cargameStrategy.CarRacingGameStrategy;
import step5.domain.cargameStrategy.RandomCarRacingGameStrategy;
import step5.view.InputView;
import step5.view.OutputView;
import step5.view.dto.InputDto;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final CarRacingGameStrategy carRacingGameStrategy = new RandomCarRacingGameStrategy();

    public static void main(String[] args) {
        InputDto inputDto = InputView.load();

        int numberOfAttempts = inputDto.getNumberOfAttempts();
        String[] inputCarNames = inputDto.getInputCarnames();
        List<Car> carList = carListToParticipate(inputCarNames);

        CarRacingGame carRacingGame = new CarRacingGame(carRacingGameStrategy, carList, numberOfAttempts);
        carRacingGame.play();

        OutputView.printResult(carRacingGame);
    }

    private static List<Car> carListToParticipate(String[] inputCarNames) {
        List<Car> carList = new ArrayList<>();
        for (String inputCarName : inputCarNames) {
            Car car = new Car(inputCarName);
            carList.add(car);
        }
        return carList;
    }
}
