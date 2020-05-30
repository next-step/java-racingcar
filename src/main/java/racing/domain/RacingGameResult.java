package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameResult {
    private final List<RacingCars> allRoundRacingCars;

    public RacingGameResult() {
        allRoundRacingCars = new ArrayList<>();
    }

    public void addResult(RacingCars racingCars) {
        allRoundRacingCars.add(racingCars.getDeepCopyRacingCars());
    }

    public List<RacingCars> getAllRoundRacingCars() {
        return allRoundRacingCars;
    }

    public List<Car> getWinners() {
        int winnerPosition = getLastRacingCars().getWinnerPosition();
        List<Car> finalRoundCars = getLastRacingCars().getCarList();

        return finalRoundCars.stream().filter(car -> comparePosition(car.getPosition(), winnerPosition)).collect(Collectors.toList());
    }

    private RacingCars getLastRacingCars() {
        int finalRound = allRoundRacingCars.size() - 1;
        return allRoundRacingCars.get(finalRound);
    }

    private boolean comparePosition(int position1, int position2) {
        return position1 == position2;
    }

}
