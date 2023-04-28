package racing.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
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

    public Cars findWinners() {
        int maxPosition = findMaxPosition();
        List<Car> winners = new ArrayList<>();
        this.carList.forEach(car -> addWinner(car, maxPosition, winners));
        return new Cars(winners);
    }

    private int findMaxPosition() {
        OptionalInt max = this.carList.stream()
                .mapToInt(Car::position)
                .max();
        if (max.isEmpty()) {
            return 0;
        }
        return max.getAsInt();
    }

    private void addWinner(Car car, int maxPosition, List<Car> winners) {
        if (car.isWinner(maxPosition)) {
            winners.add(car);
        }
    }

    public String winnerNames() {
        StringBuilder sb = new StringBuilder();
        this.carList.forEach(car -> {
            sb.append(car.name());
            sb.append(", ");
        });
        sb.delete(sb.lastIndexOf(", "), sb.length());
        return sb.toString();
    }
}
