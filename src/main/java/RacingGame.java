import domain.Car;
import domain.CarName;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {

    private static final Integer CONDITON = 4;

    public List<Car> makeCars(List<String> names) {
        List<CarName> carNames = names.stream().map(CarName::new).collect(Collectors.toList());
        return carNames.stream()
                .map(carName -> new Car(carName))
                .collect(Collectors.toList());
    }

    public void game(List<Car> cars) {
        //인스턴스 변수 to 지역변수
        Random random = new Random();
        cars.forEach(car -> {
            car.moveWithCondition(random.nextInt(10), CONDITON);
        });
    }

    //max를 car객체로 넘겨서 처리하도록 변경
    public List<Car> getWinners(List<Car> cars) {
        return cars.stream()
                .filter(car -> car.isSameDistanceCar(getMaxPositionCar(cars)))
                .collect(Collectors.toList());
    }

    private Car getMaxPositionCar(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("차량 리스트가 비었습니다."));
    }

}
