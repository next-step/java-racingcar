package racingcar;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.strategy.MovingStrategy;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import racingcar.vo.CarDto;
import racingcar.vo.CarsDto;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final MovingStrategy strategy;

    public Game(MovingStrategy strategy) {
        this.strategy = strategy;
    }

    public void racingCars() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        CarsDto carsDto = inputView.initCars();
        Cars cars = carsDtoToCars(carsDto.getList());
        for (int i = 0; i < inputView.getRounds(); i++) {
            cars = cars.moveAll(this.strategy);
            resultView.printAllCarsMovement(carsToCarsDto(cars));
        }
        resultView.printWinners(cars.getWinners());
    }

    private Cars carsDtoToCars(List<CarDto> cars) {
        return new Cars(cars.stream()
                .map(carDto -> new Car(carDto.getCarName(), carDto.getCarPosition()))
                .collect(Collectors.toList()));
    }

    private CarsDto carsToCarsDto(Cars cars) {
        return new CarsDto(cars.getList().stream()
                .map(car -> new CarDto(car.getCarName(), car.getCarPosition()))
                .collect(Collectors.toList()));
    }

}
