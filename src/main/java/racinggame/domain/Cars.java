package racinggame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import racinggame.dto.CarDto;
import racinggame.dto.SnapShotDto;
import racinggame.random.Radom;

public class Cars {

    private final SnapShotStore snapShotStore = new SnapShotStore();
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
            cars.add(Car.defaultCar());
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
        snapShotStore.save(nowState());
    }

    private void move(int index, int capacity) {
        Car car = cars.get(index);
        car.move(capacity);
    }

    private List<CarDto> nowState() {
        List<CarDto> result = new ArrayList<>();
        for (Car car : cars) {
            result.add(new CarDto(car));
        }
        return result;
    }

    public SnapShotDto history() {
        return this.snapShotStore.snapShot();
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
}
