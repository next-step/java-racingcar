package step33;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Car {
    private List<Car> cars;

    public Car(List<Car> cars) {
        this.cars = cars;
    }

    public void createCar(int number) {
        if (cars.size() >= number) {
            throw new IllegalArgumentException("잘못된 번호입니다.");
        }
        addCarToCars(number);
    }

    private void addCarToCars(int number) {
        for (int i = 0; i < number; i++) {
            addCar();
        }
    }

    public void moveCars(boolean isOver, int index) {
        if (isOver) {
            cars.get(index).addCar();
        }
    }

    private void addCar() {
        cars.add(new Car(new ArrayList<>()));
    }

    public List<Integer> carsSizes() {
        return cars.stream()
                .map(
                        s -> s.cars
                                .size())
                .collect(
                        Collectors.toList());
    }


}
