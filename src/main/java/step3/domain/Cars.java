package step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void proceedWithPolicy(ProceedPolicy proceedPolicy) {
        if (proceedPolicy == null) {
            throw new RuntimeException("실제 게임 진행은 전진 정책이 필요합니다.");
        }

        for (Car car : cars) {
            car.proceedWithPolicy(proceedPolicy);
        }
    }

    public int size() {
        return cars.size();
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
