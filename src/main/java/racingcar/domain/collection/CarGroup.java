package racingcar.domain.collection;

import racingcar.asset.CarGroupConst;
import racingcar.domain.model.Car;
import racingcar.domain.model.Memento;
import racingcar.domain.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * NOTE: Car 의 일급 컬렉션
 * FIXME: racingcar.domain.collection 가 적절한지 확인 필요.
 * 자바의 Collection 데이터 타입에 종속되는 패키지명이므로 혼동을 줄 수 있음.
 * Memento 클래스 한개만 의존하고 있으므로,
 * composition 이나, aggregation 이라는 표현은 부적절해보임.
 * FIXME: collection 보다 적절한 패키지명을 추천받을 필요 있음.
 */
public class CarGroup {

    private List<Car> cars;

    public CarGroup(String nameCsv, MoveStrategy strategy) {
        String[] nameArr = nameCsv.split(CarGroupConst.NAME_SPLIT_REGEX);
        cars = Arrays.stream(nameArr)
                .map(name -> Car.createCar(name, strategy))
                .collect(Collectors.toList());
    }

    public void moveCar() {
        for (Car car : cars) {
            car.move();
        }
    }

    public Memento createMemento() {
        Memento memento = new Memento();
        for (Car car : cars) {
            memento.addCar(car.clone());
        }
        return memento;
    }

    public void restoreMemento(Memento memento) {
        cars = memento.getCars();
    }

    protected List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .collect(Collectors.toList());
    }

    protected List<Car> getWinners(List<Car> cars) {
        return cars.stream()
                .collect(
                        Collectors.groupingBy(Car::getPosition)
                ).entrySet()
                .stream()
                .max(
                        Comparator.comparing(Map.Entry::getKey)
                ).get()
                .getValue();
    }

    public List<Car> getWinners() {
        return getWinners(cars);
    }

    public void setStrategy(MoveStrategy strategy) {
        for (Car car : cars) {
            car.setStrategy(strategy);
        }
    }
}
