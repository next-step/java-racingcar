package racingcar.model;

import racingcar.utils.StringUtil;

import java.util.Collections;
import java.util.List;
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

    public String getResult(){
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName() + ": " + StringUtil.repeat("-", car.getPosition()));
            sb.append("\n");
        }
        return sb.toString();
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

}
