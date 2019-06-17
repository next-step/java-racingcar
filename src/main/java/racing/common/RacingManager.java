package racing.common;

import racing.Car;
import racing.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingManager {
    private Cars cars;
    private RandomNumberGenerator randomGenerator;
    
    public RacingManager(Cars cars) {
        this.cars = cars;
    }
    
    public RacingManager(String carNames) {
        this.cars = new Cars(Arrays.stream(carNames.split(","))
          .map(carName -> new Car(carName))
          .collect(Collectors.toList())
        );
        randomGenerator = new RandomNumberGenerator(RacingSettings.MAX_RANDOM_MOVABLE_NUMBER.getValue());
    }
    
    public void moveCars() {
        cars.getCars().stream()
          .filter(car -> randomGenerator.getNumber() > RacingSettings.MIN_MOVABLE_NUMBER.getValue())
          .forEach(car -> car.forward());
    }
    
    public Cars getWinners() {
        List<Car> players = cars.getCars();
        List<Car> winners = new ArrayList<>();
        for (int i = 0, size = players.size(); i < size; i++) {
            if (0 == winners.size()) {
                winners.add(players.get(i));
            } else {
                int winnerPosition = winners.get(0).getPosition();
                Car player = players.get(i);
                int playerPosition = player.getPosition();
                if (winnerPosition < playerPosition) {
                    winners = new ArrayList<>();
                    winners.add(player);
                } else if (winnerPosition == playerPosition) {
                    winners.add(player);
                }
            }
        }
        return new Cars(winners);
    }
    
    public Cars getCars() {
        return cars;
    }
    
}
