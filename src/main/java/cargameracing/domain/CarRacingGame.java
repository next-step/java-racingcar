package cargameracing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Domain(Model) Role
 * @author minji
 */
public class CarRacingGame {
    private Car[] cars;
    private TryNo tryNo;

    public CarRacingGame(List<String> carName, int playCount){
        int count = carName.size();
        cars = new Car[count];
        for (int i = 0; i < count; i++) {
            cars[i] = new Car(carName.get(i));
        }
        this.tryNo = new TryNo(playCount);
    }

    public void playGame(MovingStrategy movingStrategy) {
        Arrays.stream(cars)
                .forEach(cars -> cars.junjinUp(movingStrategy));
    }

    public Car[] getCars() {
        return this.cars;
    }
    public TryNo getTryNo() { return this.tryNo; }

    public List<String> displayFinalWinners() {
       return filterWinners();
    }

    public List<String> filterWinners() {
        int maxPosition = getMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car:cars) {
            if (maxPosition == car.getJunjin()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car:cars) {
            int position = car.getJunjin();
            if (maxPosition < position) {
                maxPosition = position;
            }
        }
        return maxPosition;
    }
}
