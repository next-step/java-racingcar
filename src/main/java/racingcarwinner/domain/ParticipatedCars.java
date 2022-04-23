package racingcarwinner.domain;

import racingcarwinner.Exception.NoWinnerException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParticipatedCars {
    private List<Car> participatedCars;
    private int max;

    public ParticipatedCars(String[] names) {
        this.participatedCars = Arrays.stream(names).map((name) -> new Car(name)).collect(Collectors.toList());
    }

    public List<Car> getParticipatedCars() {
        return participatedCars;
    }

    public List<Car> getMaxPositionList() {
        int max = getMaxPosition();
        return participatedCars.stream().filter(car -> car.isMaxPosition(max)).collect(Collectors.toList());
    }

    private int getMaxPosition() {
        for(Car car : participatedCars) {
            max = car.isEqualMax(max);
        }

        if(max == 0)    throw new NoWinnerException("모든 자동차가 움직이지 못해 우승자를 뽑을 수 없습니다.");
        return max;
    }

}
