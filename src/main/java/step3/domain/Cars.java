package step3.domain;

import java.util.List;
import java.util.stream.Collectors;
import step3.exception.NoProceedPolicyException;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void proceedWithPolicy(ProceedPolicy proceedPolicy) {
        if (proceedPolicy == null) {
            throw new NoProceedPolicyException("실제 게임 진행은 전진 정책이 필요합니다.");
        }

        for (Car car : cars) {
            car.proceedWithPolicy(proceedPolicy);
        }
    }

    public int size() {
        return cars.size();
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<String> firstRankNames() {
        int maxPosition = cars.stream()
            .mapToInt(Car::getPosition)
            .max().getAsInt();

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public List<Integer> getPositions() {
        return cars.stream()
            .map(Car::getPosition)
            .collect(Collectors.toList());
    }

    public void proceed() {
        cars.forEach(Car::proceed);
    }
}
