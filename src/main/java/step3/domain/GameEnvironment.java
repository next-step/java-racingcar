package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class GameEnvironment {

    private Integer carCount;
    private Integer tryCount;
    private List<Car> cars = new ArrayList<>();

    public void setTry(Integer tryCountFromInput) {
        validateCount(tryCountFromInput);
        this.tryCount = tryCountFromInput;
    }

    private void validateCount(Integer count) {
        if (count <= 0) {
            throw new IllegalArgumentException("invalid count");
        }
    }

    public void setCar(Integer carCountFromInput) {
        validateCount(carCountFromInput);
        this.carCount = carCountFromInput;
        cars = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public List<Car> getCars() {
        return cars;
    }
}
