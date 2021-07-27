package racing.model;


import java.util.List;
import java.util.stream.Collectors;

public class Racing {
    private Cars cars = new Cars();
    private int playCount = 0;

    public void prepareRacing(String carNames, int playCount) {
        this.playCount = playCount;
        this.cars.prepareCars(carNames);
    }

    public Cars participants() {
        return this.cars;
    }

    public Boolean endGame(int gameCount) {
        return this.playCount == gameCount ? true : false;
    }

    public List<Car> winner() {
        int maxDistance = cars.getMaxDistance();
        List<Car> cars = participants().carList()
                .stream()
                .filter(car -> car.totalDistance() == maxDistance)
                .collect(Collectors.toList());
        return cars;
    }
}
