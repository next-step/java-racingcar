package racingcar;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void move() {
        cars.forEach(Car::moveOrStop);
        print();
    }

    public void print() {
        for (Car car : cars) {
            System.out.println(append(car.getPosition()));
        }
        System.out.println("");
    }

    public static String append(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

}
