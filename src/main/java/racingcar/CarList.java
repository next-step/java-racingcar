package racingcar;

import java.util.Collections;
import java.util.List;

public class CarList {
    private static List<Car> cars;

    public CarList(final List<Car> cars) {
        // 변경 불가한 list 만들기
        this.cars = Collections.unmodifiableList(cars);
    }

    public void move(RandomMove randomMove) {
        int position = new Car().getPosition();
        for(Car car : cars) {
            if(randomMove.canMove()){
                car.move();
            }
        }
    }

    public List<Car> getCar() {
        return cars;
    }
}

