package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    private int time;
    private List<Car> cars = new ArrayList<>();
    
    public RacingGame(String[] carNames, int time) {
        for (int carNumber = 0; carNumber < carNames.length; carNumber++) {
            cars.add(new Car(1, carNames[carNumber]));
        }
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public List<Car> playRound() {
        for (Car car : cars) {
            car.move(RandomCreator.createNewPosition());
        }
        return cars;
    }

    public String sortWinners() {
        sortCars();
        return collectWinners(cars);
    }

    public String collectWinners(List<Car> cars) {
        int firstWinner = cars.get(0).getPosition();
        String winners = cars.get(0).getName();
        for(int carNumber = 1; carNumber < cars.size(); carNumber++) {
            winners += nameCompare(firstWinner, cars.get(carNumber));
        }
        return winners;
    }

    private void sortCars() {
        Collections.sort(cars);
    }

    public String nameCompare(int firstWinnerPosition, Car otherPlayer) {
        if(firstWinnerPosition == (otherPlayer.getPosition())) {
            return ", " + otherPlayer.getName();
        }
        return "";
    }

}
