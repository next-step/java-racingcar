package racing.domain;


import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : 0giri
 * @since : 2023/04/16
 */
public class Cars {

    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = deepCopy(carList);
    }

    public List<Car> deepCopyCarList() {
        return deepCopy(this.carList);
    }

    private List<Car> deepCopy(List<Car> carList) {
        return carList.stream().map(Car::new).collect(Collectors.toUnmodifiableList());
    }

    public void canStartRace() {
        if (this.carList.size() < 2) {
            throw new IllegalArgumentException("경주를 위해 참여 자동차는 2대 이상이어야 합니다.");
        }
    }
}
