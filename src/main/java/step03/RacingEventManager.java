package step03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RacingEventManager {

    private RacingCarFactory racingCarFactory;
    private RacingCarRound racingCarRound;

    public RacingEventManager(String carNames, int tryCount) {
        racingCarFactory = new RacingCarFactory(carNames);
        racingCarRound = new RacingCarRound(tryCount);
    }

    public void startRandomRacing() {
        startRacing(new RandomMoveStrategy());
    }

    private void startRacing(MoveStrategy moveStrategy) {
        while (!racingCarRound.isFinishRound()) {
            racingCarFactory.moveCars(moveStrategy);
            racingCarRound.showRacingRoundResult(racingCarFactory.getRacingCars());
        }
        racingCarRound.showRacingRoundFinalWinner(getWinnerRacingCars(racingCarFactory.getRacingCars()));
    }

    public List<RacingCar> getWinnerRacingCars(List<RacingCar> racingCars) {
        List<RacingCar> winners = new ArrayList<>();

        racingCars.sort(Comparator.comparing((racingCar -> racingCar.getRacingCarData().getMovingRange())));
        Collections.reverse(racingCars);

        for (RacingCar racingCar : racingCars) {
            if (winners.isEmpty()) {
                winners.add(racingCar);
                continue;
            }
            if (compareRacingCarMoveRange(winners.get(winners.size() - 1), racingCar)) {
                winners.add(racingCar);
            }
        }
        Collections.reverse(winners);
        return winners;
    }

    private boolean compareRacingCarMoveRange(RacingCar winnerRacingCar, RacingCar challengerRacingCar) {
        return winnerRacingCar.getRacingCarData().getMovingRange() <= challengerRacingCar.getRacingCarData().getMovingRange();
    }
}
