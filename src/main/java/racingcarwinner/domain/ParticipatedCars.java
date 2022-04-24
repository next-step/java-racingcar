package racingcarwinner.domain;

import racingcarwinner.Exception.NoWinnerException;
import racingcarwinner.strategy.MoveStrategy;
import racingcarwinner.strategy.RandomMoveStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipatedCars {
    private final List<Car> participatedCars;
    private final MoveStrategy randomStrategy;
    private int max;

    public ParticipatedCars(String[] names) {
        this.participatedCars = Arrays.stream(names).map(Car::new).collect(Collectors.toList());
        randomStrategy = new RandomMoveStrategy();
    }

    public List<Car> getMaxPositionList() {
        assertMaxValue();
        return participatedCars.stream().filter(car -> car.isMaxPosition(max)).collect(Collectors.toList());
    }

    private void assertMaxValue() {
        for(Car car : participatedCars) {
            max = car.isMax(max);
        }
        if(max == 0)    throw new NoWinnerException();
    }

    public List<Car> getParticipatedCars() {
        return participatedCars;
    }

    public void moveAllCars() {
        participatedCars.forEach(car ->  car.move(randomStrategy));
    }
}
