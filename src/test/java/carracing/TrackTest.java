package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.assertThat;

public class TrackTest {
    private static final List<String> carNames = List.of("pobi", "edu");

    @Test
    @DisplayName("생성/자동차N대 생성/생성된다.")
    void createTrack() {
        Track track = new Track(Cars.makeCars(carNames));
        assertThat(track).isInstanceOf(Track.class);
    }

    @Test
    @DisplayName("우승자/포지션이 가장 높은 사람이/우승자이다.")
    void getWinner() {
        // given
        Track track = new Track(Cars.makeCars(carNames));
        track.run();
        int maxPosition = track.carHistory().getCars().stream().max(comparing(Car::getPosition)).get().getPosition();

        // when
        List<Car> winners = track.winners();

        // then
        winners.forEach(winner -> assertThat(winner.getPosition()).isEqualTo(maxPosition));
    }
}
