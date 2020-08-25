package racingcar.domain;

import java.util.List;
import java.util.Objects;

import static racingcar.domain.RacingGamesFactory.createRacingGames;

public class RacingGames {

    private final List<RacingGame> racingGames;
    private final RacingCounts racingCounts;

    public RacingGames(String input, int racingCounts) {
        this.racingGames = createRacingGames(input, racingCounts);
        this.racingCounts = new RacingCounts(racingCounts);
    }

    public List<RacingGame> getRacingGames() {
        return racingGames;
    }

    public int getRacingCounts() {
        return racingCounts.getRacingCounts();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass( ) != o.getClass( )) return false;
        RacingGames that = (RacingGames) o;
        return Objects.equals(racingGames, that.racingGames) &&
                Objects.equals(racingCounts, that.racingCounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(racingGames, racingCounts);
    }
}
