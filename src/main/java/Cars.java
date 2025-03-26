import java.util.List;

public class Cars {

    public final List<Car> cars;

    public Cars(List<Car> carList) {
        if (carList.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 한 대 이상 있어야 합니다.");
        }
        this.cars = carList;
    }

    public void moveAll(boolean condition){
        for (Car car : cars) {
            car.move(condition);
        }
    }
}
