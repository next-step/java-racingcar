package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

public class RaceTest {
    private static final CarName POBI = new CarName("pobi");
    private static final CarName CRONG = new CarName("crong");
    private static final List<String> NAMES = List.of("pobi", "crong");

    @Test
    @DisplayName("한 회차를 진행하면 차들이 움직이고 회차 결과를 반환한다")
    void playRound() {
        Iterator<Integer> numbers = List.of(4, 3).iterator();
        Race race = new Race(NAMES, new TryCount(1), numbers::next);

        RoundResult result = race.playRound();

        assertThat(result.carResults()).containsExactly(new CarResult(POBI, 1), new CarResult(CRONG, 0));
    }

    @Test
    @DisplayName("회차를 거듭하면 위치가 누적된다")
    void accumulatePositionAcrossRounds() {
        Iterator<Integer> numbers = List.of(4, 3, 4, 4).iterator();
        Race race = new Race(NAMES, new TryCount(2), numbers::next);

        race.playRound();
        RoundResult result = race.playRound();

        assertThat(result.carResults()).extracting(CarResult::position).containsExactly(2, 1);
    }

    @Test
    @DisplayName("반환된 회차 결과는 이후 경기가 진행돼도 바뀌지 않는다")
    void resultNotAffectedByLaterRounds() {
        Iterator<Integer> numbers = List.of(4, 3, 4, 4).iterator();
        Race race = new Race(NAMES, new TryCount(2), numbers::next);

        RoundResult first = race.playRound();
        race.playRound();

        assertThat(first.carResults()).extracting(CarResult::position).containsExactly(1, 0);
    }

    @Test
    @DisplayName("시도할 횟수가 남아 있으면 진행 중이다")
    void inProgressWhenTryCountRemains() {
        Iterator<Integer> numbers = List.of(4, 3).iterator();
        Race race = new Race(NAMES, new TryCount(2), numbers::next);

        assertThat(race.isInProgress()).isTrue();
        race.playRound();
        assertThat(race.isInProgress()).isTrue();
    }

    @Test
    @DisplayName("시도할 횟수만큼 진행하면 경기가 끝난다")
    void finishedAfterAllRounds() {
        Iterator<Integer> numbers = List.of(4, 3).iterator();
        Race race = new Race(NAMES, new TryCount(1), numbers::next);

        race.playRound();

        assertThat(race.isInProgress()).isFalse();
    }

    @Test
    @DisplayName("경기가 끝난 뒤 회차를 진행하면 IllegalStateException")
    void throwsExceptionWhenPlayAfterFinished() {
        Iterator<Integer> numbers = List.of(4, 3).iterator();
        Race race = new Race(NAMES, new TryCount(1), numbers::next);
        race.playRound();

        assertThatIllegalStateException().isThrownBy(race::playRound);
    }

    @Test
    @DisplayName("경기가 끝난 뒤 회차를 진행해도 차들은 움직이지 않는다")
    void carsDoNotMoveAfterFinished() {
        Iterator<Integer> numbers = List.of(4, 3, 4, 4).iterator();
        Race race = new Race(NAMES, new TryCount(1), numbers::next);
        race.playRound();

        assertThatIllegalStateException().isThrownBy(race::playRound);
        assertThat(numbers.hasNext()).isTrue();
    }
}
