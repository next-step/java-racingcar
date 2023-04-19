package study.step3.domain;

import study.step3.dto.CarRacingDto;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    private List<String> carNames;
    private int countOfMove;
    private Cars cars;

    public CarRacing(List<String> carNames, int countOfMove) {
        this.carNames = carNames;
        this.countOfMove = countOfMove;
        this.cars = new Cars(carNames,
                new LessThanMoveCondition(4, new RandomMove()));
    }

    public List<CarRacingDto> play() {
        List<CarRacingDto> stagesOfPositions = new ArrayList<>();
        for (int i = 0; i < countOfMove; i++) {
            cars.moveForward();
            stagesOfPositions.add(new CarRacingDto(cars.toPositionOfCars()));
        }
        return stagesOfPositions;
    }

    public List<String> findWinners() {
        return cars.findWinners();
    }
}
