package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarManager {
    private final List<Car> joinCarList = new ArrayList<>();

    public void joinCar() {
        joinCarList.add(new Car());
    }

    public void moveCars(){
        joinCarList.stream().forEach(car -> car.move());
    }

    public List<Integer> getRacingStatus() {
        return joinCarList.stream()
                .map(car -> car.getLocation())
                .collect(Collectors.toList());
    }
}
