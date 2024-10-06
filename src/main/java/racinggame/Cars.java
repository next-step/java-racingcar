package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(int count) {
        if(!isPositive(count)){
            throw new IllegalArgumentException("음수를 사용 할 수 없습니다.");
        }
        return new Cars(carInitialization(count));
    }

    private static ArrayList<Car> carInitialization(int carCount) {
        assert -1 < carCount;

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(0));
        }
        return cars;
    }

    private static boolean isPositive(int number){
        return 0<=number;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void moveAll() {
        Random random = new Random();
        for (Car car:cars){
            car.move(random.nextInt(10));
        }
    }
}
