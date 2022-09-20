package step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRace {

    private List<Car> cars;
    //그럼 그냥 일급컬렉션은 불변으로 하지말깜
    //이것두 한번 리뷰어한테 물어봐야겠담.
    // dnd
    private final NumberGenerator numberGenerator;

    public CarRace(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public int size() {
        return cars.size();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> cars() {
        return new ArrayList<>(cars);
    }

    public void move() {
        this.cars = cars.stream()
                .map(car -> move(car, numberGenerator))
                .collect(Collectors.toList());
    }

    private Car move(Car car, NumberGenerator numberGenerator) {
        if (numberGenerator.randomNumber() < 4) {
            return car;
        }
        return car.move();
    }
}
