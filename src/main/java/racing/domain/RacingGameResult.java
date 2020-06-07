package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private final List<Cars> allRoundCars;

    public RacingGameResult() {
        allRoundCars = new ArrayList<>();
    }

    public void addResult(Cars cars) {
        allRoundCars.add(cars.getDeepCopyRacingCars());
    }

    public List<Cars> getAllRoundCars() {
        return allRoundCars;
    }

    public List<Car> getWinners() {
        int winnerPosition = getLastRacingCars().getWinnerPosition();
        List<Car> finalRoundCars = getLastRacingCars().getCars();

        return finalRoundCars.stream().filter(car -> comparePosition(car.getPosition(), winnerPosition)).collect(Collectors.toList());
    }

    private Cars getLastRacingCars() {
        int finalRound = allRoundCars.size() - 1;
        return allRoundCars.get(finalRound);
    }

    private boolean comparePosition(int position1, int position2) {
        return position1 == position2;
    }

}
