package service;

import domain.Cars;
import domain.Positions;
import util.MoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarRacingService {
    private final MoveStrategy moveStrategy;
    private Cars cars;

    public CarRacingService(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void registerNewCars(int number) {
        cars = new Cars(number);
    }

    public List<Positions> startRacing(int count) {
        List<Positions> positionsList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            positionsList.add(cars.moveCars(moveStrategy));
        }
        return positionsList;
    }
}
