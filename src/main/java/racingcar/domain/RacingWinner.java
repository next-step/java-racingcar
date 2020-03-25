package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {

    private final List<RacingCar> winner;
    public Integer score;

    public RacingWinner(List<RacingCar> winner) {
        this.winner = winner;
        this.score = getHighScore();
    }

    public List<String> findWinnerNames() {
        return winner.stream().filter(w -> w.getPosition() == score)
                .map(RacingCar::getName)
                .collect(Collectors.toList());
    }

    private int getHighScore() {
        return winner.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .getAsInt();
    }

}
