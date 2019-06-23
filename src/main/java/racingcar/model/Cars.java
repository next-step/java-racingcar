package racingcar.model;

import racingcar.utils.StringUtil;

import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> move(){
        for(Car car: cars){
            car.move();
        }
        return cars;
    }

    public void printResult(){
        for (Car car : cars) {
            System.out.println(car.getName() + ": " + StringUtil.repeat("-", car.getPosition()));
        }
    }

    public List<Car> getWinners() {
        return cars.stream().collect(Collectors.groupingBy(c -> c.getPosition()))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Integer.compare(e1.getKey(), e2.getKey()) * -1)
                .map(e -> e.getValue())
                .findFirst()
                .orElse(Collections.emptyList());
    }

    public void printWinners() {
        StringJoiner joiner = new StringJoiner(", ", "", "가 최종 우승했습니다.");
        for (Car car : getWinners()) {
            joiner.add(car.getName());
        }
        System.out.println(joiner.toString());
    }
}
