package step5.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        this.carList = create(carNames);
    }

    // 테스트 코드를 위한 생성자 (더미 매개변수를 받아서 해도 괜찮은 건지 모르겠습니다  ㅠ)
    public Cars(List<Car> cars, int dummy) {
        this.carList = cars;
    }

    public List<Car> getCarList() {
        return carList;
    }

    private List<Car> create(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carNames.size(); ++i) {
            cars.add(new Car(carNames.get(i)));
        }

        return cars;
    }

    public void move() {
        for (int i = 0; i < carList.size(); ++i) {
            Car car = carList.get(i);
            car.move(new RandomMovingStrategy());
        }

        System.out.println();
    }

    public String findWinner() {
        Position position = maxDistance();
        return carList.stream()
                .filter(car -> car.getPosition().equals(new Position(position.getPosition())))
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    private Position maxDistance() {
        Collections.sort(carList, (o1, o2) -> o2.getPosition().compareTo(o1.getPosition()));
        return carList.get(0).getPosition();
    }
}
