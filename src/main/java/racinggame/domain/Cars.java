package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racinggame.dto.CarDto;
import racinggame.random.Radom;

public class Cars {

    private static final int DEFAULT_POSITION = 1;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        if(cars.isEmpty())throw new IllegalArgumentException("자동차가 비여 있을 수 없습니다.");
        this.cars = cars;
    }

    public static Cars of(int count) {
        return new Cars(carInitialization(count));
    }

    private static ArrayList<Car> carInitialization(int carCount) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car(DEFAULT_POSITION));
        }
        return cars;
    }

    public int count() {
        return cars.size();
    }

    public void move(Radom radom) {
        for(int i=0;i<count();i++){
            move(i,radom.generate());
        }
    }

    private void move(int index, int capacity) {
        Car car = cars.get(index);
        car.move(capacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

    public List<CarDto> result() {
        List<CarDto> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(new CarDto(car));
        }
        return result;
    }
}
