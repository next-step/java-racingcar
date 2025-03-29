import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarsSnapShots {
    private final List<Cars> carsSnapShots;

    public CarsSnapShots() {
        this.carsSnapShots = new ArrayList<>();
    }

    public void add(Cars cars) {
        this.carsSnapShots.add(new Cars(cars));
    }

    public List<Cars> getCars() {
        return this.carsSnapShots;
    }
}
