package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {

    private final List<RacingCar> winners;
    public Integer distance;

    public RacingWinner(List<RacingCar> winners) {
        this.winners = winners;
        this.distance = getWinningDistance();
    }

    public List<String> findWinnerNames() {
        return winners.stream().filter(w -> w.getDistance() == distance)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int getWinningDistance() {
        return winners.stream()
                .mapToInt(RacingCar::getDistance)
                .max()
                .getAsInt();
    }

}
