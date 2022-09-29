package racing.domain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WinnerRacingCars implements Comparator<RacingCar> {

    private List<RacingCar> winners;

    public WinnerRacingCars(final List<RacingCar> racingCars) {

        this.winners = racingCars;
    }

    public void win() {

        final RacingCar winner = descend();
        this.winners = win(winner);
    }

    private List<RacingCar> win(final RacingCar first) {

        return this.winners.stream()
                .filter(racing -> isaBoolean(first, racing))
                .collect(Collectors.toList());
    }

    private boolean isaBoolean(final RacingCar first, final RacingCar racing) {

        return racing.getPosition() == first.getPosition();
    }

    private RacingCar descend() {

        return this.winners.stream()
                .min(this::compare)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public int compare(final RacingCar racingCar, final RacingCar racingCar2) {

        return racingCar2.getPosition() - racingCar.getPosition();
    }

    public List<RacingCar> getWinners() {

        return this.winners;
    }

    public String pick() {

        final StringBuilder winner = new StringBuilder();
        int index = 1;
        for (RacingCar racingCar : winners) {
            pick(winner, index, racingCar);
            index++;
        }
        return winner.toString();
    }

    private void pick(final StringBuilder winner, final int index, final RacingCar racingCar) {

        winner.append(racingCar.getName().getCarName());
        if(index != winners.size()) {
            winner.append(",");
        }
    }
}
