package cargameracing;

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
/*
        for (int j = 0; j < cars.length; j++) {
            cars[j].junjinUp(movingStrategy);
        }
*/
        Arrays.stream(cars)
                .forEach(cars -> cars.junjinUp(movingStrategy));
    }

    public Car[] getCars() {
        return this.cars;
    }
    public TryNo getTryNo() { return this.tryNo; }

    public void displayFinalWinners() {
        filterWinners();
    }

    public void filterWinners() {
        int maxPosition = getMaxPosition();

        List<String> winners = new ArrayList<>();
        for (Car car:cars) {
            if (maxPosition == car.getJunjin()) {
                winners.add(car.getName());
            }
        }
        displayWinners(winners);
    }

    public void displayWinners(List<String> winners) {
        for (int i = 0; i < winners.size(); i++) {
            if (i != winners.size() - 1) {
                System.out.print(winners.get(i) + ", ");
            }
            if (i == winners.size() - 1) {
                System.out.print(winners.get(i));
            }
        }
        System.out.print("가 최종 우승했습니다.");
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
