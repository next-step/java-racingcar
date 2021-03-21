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
        String winnerName = getRacingWinnerName(getWinnerRacingCars(racingCarFactory.getRacingCars()));
        racingCarRound.showRacingRoundFinalWinner(winnerName);
    }

    public List<RacingCar> getWinnerRacingCars(List<RacingCar> racingCars) {
        List<RacingCar> winners = new ArrayList<>();

        racingCars.sort(Comparator.comparing((racingCar -> racingCar.getRacingCarData().getMovingRange())));
        Collections.reverse(racingCars);

        for (RacingCar racingCar : racingCars) {
            setWinnerList(winners, racingCar);
        }
        Collections.reverse(winners);
        return winners;
    }

    private List<RacingCar> setWinnerList(List<RacingCar> winners, RacingCar racingCar) {
        if (winners.isEmpty()) {
            winners.add(racingCar);
            return winners;
        }
        if (compareRacingCarMoveRange(winners.get(winners.size() - 1), racingCar)) {
            winners.add(racingCar);
        }
        return winners;
    }

    private boolean compareRacingCarMoveRange(RacingCar winnerRacingCar, RacingCar challengerRacingCar) {
        return winnerRacingCar.getRacingCarData().getMovingRange() <= challengerRacingCar.getRacingCarData().getMovingRange();
    }

    public String getRacingWinnerName(List<RacingCar> winners) {
        StringBuilder winnersName = new StringBuilder();
        for (RacingCar racingCar : winners) {
            addDelimiter(winnersName);
            winnersName.append(racingCar.getRacingCarData().getCarName());
        }
        return winnersName.toString();
    }

    private StringBuilder addDelimiter(StringBuilder winnerName) {
        if (winnerName.length() > 0) {
            winnerName.append(ResultView.WINNER_DELIMITER);
        }
        return winnerName;
    }
}
