package step5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarList {
    private final List<Car> carList;

    public CarList() {
        this.carList = new ArrayList<>();
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> create(List<String> carNameList) {
        for (int i = 0; i < carNameList.size(); ++i) {
            carList.add(new Car(carNameList.get(i)));
        }

        return carList;
    }

    // 이렇게 외부에서 주입 받고 메소드 끼리 의존관계 제거하니 테스트 코드 작성하기도 쉽고 더 깔끔해보이는데 어떻게 생각하시는지 궁금합니다 !!
    public String findWinner(List<Car> cars, int carMaxDistance) {
        return cars.stream()
                .filter(car -> car.getPosition().equals(new Position(carMaxDistance)))
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    // 1. 확실히 전체적으로 외부에서 값을 주입 받으니까 테스트 작성하기가 쉬운거 같은데 잘 리팩터링 했을까요??
    // 2. 테스트를 하기 위해서는 거의 다 public 으로 바꿔줘야 하는뎀... 어떤 부분을 제가 인지 못하고 있을까요 ??
    // 예를들어.. maxDistance 를 제대로 구하는지 테스트를 한다치면 아래 메서드가 public 이어야 할 거 같은데 ,, ㅠㅠ
    public Position maxDistance(List<Car> cars) {
        cars.sort((o1, o2) -> o2.getPosition().compareTo(o1.getPosition()));
        return cars.get(0).getPosition();
    }
}
