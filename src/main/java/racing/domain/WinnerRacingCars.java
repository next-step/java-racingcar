package racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerRacingCars implements Comparator<RacingCar> {

    private List<RacingCar> winnerRacingCars;

    public WinnerRacingCars(final List<RacingCar> racingCars) {

        this.winnerRacingCars = racingCars;
    }

    public void win() {

        final RacingCar winner = descend();
        this.winnerRacingCars = win(winner);
    }

    private List<RacingCar> win(final RacingCar winner) {

        return this.winnerRacingCars.stream()
                .filter(racingCar -> winner.tie(racingCar))
                .collect(Collectors.toList());
    }

    private RacingCar descend() {

        return this.winnerRacingCars.stream()
                .min(this::compare)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public int compare(final RacingCar racingCar, final RacingCar racingCar2) {

        return racingCar2.getPosition() - racingCar.getPosition();
    }

    public List<RacingCar> getWinnerRacingCars() {

        return this.winnerRacingCars;
    }
}
