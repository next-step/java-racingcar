package racingcarwinnerrefactor.domain;

import racingcarwinnerrefactor.exception.NoWinnerException;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerCars {

    private final List<Car> cars;

    public WinnerCars(ParticipatedCars participatedCars) {
        List<Car> winnerCars = participatedCars.findWinnerList();
        assertBlank(winnerCars);
        cars = participatedCars.findWinnerList();
    }

    private void assertBlank(List<Car> winnerCars) {
        if(winnerCars.isEmpty())    throw new NoWinnerException();
    }

    @Override
    public String toString() {
        return cars.stream().map(Car::toStringName).collect(Collectors.joining(", "));
    }
}
