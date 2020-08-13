package step3.logic;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Cars {

    private static final String DIAMETER = ",";
    private static final int NAME_LENGTH_LIMIT = 5;
    private String winnerPlayers;
    public List<Car> cars;

    public Cars(String players) {
        setPlayerNameForEachCar(players.split(DIAMETER));
        this.winnerPlayers = "";
    }

    private void setPlayerNameForEachCar(String[] playerNames) {
        this.cars = Arrays.stream(playerNames)
                .filter(name -> name.length() < NAME_LENGTH_LIMIT)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void runRace() {
        this.cars.forEach(Car::makeCarMove);
    }

    public String sortWinners() {
        List<Car> winners = this.cars.stream()
                .collect(Collectors.groupingBy(
                        Car::getCarMovedCount,
                        TreeMap::new,
                        Collectors.toList()
                ))
                .lastEntry()
                .getValue();

        winners.forEach(car -> this.winnerPlayers += car.getCarName() + " ");

        return this.winnerPlayers;
    }
}
