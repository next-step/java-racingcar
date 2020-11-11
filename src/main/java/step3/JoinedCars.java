package step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoinedCars {

    private List<Car> cars;

    public JoinedCars(String joinedCarNames) {
        List<String> carNames = Arrays.asList(joinedCarNames.split(",").clone());
        cars = new ArrayList<>(carNames.size());
        carNames.forEach(it -> cars.add(new Car(it)));
    }

    public void displayRaceStateOn(RaceDisplay raceDisplay) {
        cars.stream().map(it -> CarState.of(it)).forEach( it -> {
            StringBuffer sb = new StringBuffer();
            sb.append(it.getName()).append('|');
            int length = it.getMovingDistance();
            while (length-- > 0) { sb.append('-'); }

            raceDisplay.writeLine(sb.toString());
        });
        raceDisplay.writeBlankLine();
    }

    public void tryMoving(RaceRoulette raceRoulette) {
        cars.forEach(it -> it.moveIf(() -> raceRoulette.spin() >= 4));
    }

    public List<Car> findRaceWinner(RaceWinnerFinder raceWinnerFinder) {
        return raceWinnerFinder.find(cars);
    }
}
