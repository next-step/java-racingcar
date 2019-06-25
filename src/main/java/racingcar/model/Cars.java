package racingcar.model;

import racingcar.utils.StringUtil;

import java.util.Collections;
import java.util.Comparator;
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
        int maxPosition = maxPosition();

        return cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public int maxPosition(){
        return cars.stream().map(Car::getPosition)
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

}
