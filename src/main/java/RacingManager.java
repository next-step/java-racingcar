import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    public static final String DELIMITER = ",";
    private final Cars cars;
    private final CarsSnapShots carsSnapShots;
    private final TryNum tryNum;

    public RacingManager(String carString, int tryNum) {
        if (carString.isEmpty() || tryNum <= 0) {
            throw new IllegalArgumentException("경주할 자동차를 한개 이상 입력해야 합니다. 시도 횟수는 0보다 커야 합니다.");
        }
        final List<Car> carList = Arrays.stream(carString.split(DELIMITER)).map(x -> new Car(x, 0)).collect(Collectors.toList());
        this.tryNum = new TryNum(tryNum);
        this.cars = new Cars(carList);
        this.carsSnapShots = new CarsSnapShots();
    }

    public void play() {
        if (this.tryNum.isEnd()) {
            this.cars.move();
            this.carsSnapShots.add(this.cars);
            this.tryNum.minusOne();
        }
    }

    public CarsSnapShots getCarsSnapShots() {
        return this.carsSnapShots;
    }

    public Cars getWinners() {
        return new Cars(this.cars.getByPosition(this.cars.getMaxPosition()));
    }
}
