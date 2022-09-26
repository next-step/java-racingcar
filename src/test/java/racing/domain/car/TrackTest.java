package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.generator.NumberGenerator;
import racing.domain.score.History;

class TrackTest {

    private final NumberGenerator advanced = () -> 4;

    @Test
    @DisplayName("Track 생성 테스트")
    void track_ctor_test() {
        assertThatNoException().isThrownBy(
            () -> new Track(new History(new ArrayList<>()), new Cars(List.of(new Car("pobi")))));
    }

    @Test
    @DisplayName("몇번 움직일것인지 입력하면 그거만큼 자동차가 달린다")
    void cars_inputPosition_move_test() {
        //given
        Labs labs = new Labs(1);
        History history = new History(new ArrayList<>());
        Cars cars = new Cars(List.of(new Car("pobi")), advanced);
        Track track = new Track(history, cars);

        //when
        Track racingTrack = track.racing(labs);

        //then
        Cars testCars = new Cars(List.of(new Car(1, "pobi")), advanced);
        History testHistory = new History(new ArrayList<>(List.of(testCars)));
        Track testTrack = new Track(testHistory, testCars);
        assertThat(racingTrack).isEqualTo(testTrack);
    }
}