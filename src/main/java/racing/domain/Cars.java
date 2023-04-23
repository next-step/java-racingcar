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
        this.carList = deepCopyCarList(carList);
    }

    private static List<Car> deepCopyCarList(List<Car> carList) {
        return carList.stream().map(Car::new).collect(Collectors.toUnmodifiableList());
    }

    public List<Car> deepCopyList() {
        return deepCopyCarList(this.carList);
    }
}
