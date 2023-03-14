package racing;

public class CarRace {
    Winners getWinners(Cars cars) {
        return new Winners(cars.getFastCars());
    }

    void racing(Cars cars) {
        cars.racingCars();
    }
}