package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {

    private final List<RacingCar> winners;
    public Integer score;

    public RacingWinner(List<RacingCar> winners) {
        this.winners = winners;
        this.score = getHighScore();
    }

    public List<String> findWinnerNames() {
        return winners.stream().filter(w -> w.getPosition() == score)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int getHighScore() {
        return winners.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .getAsInt();
    }

}
