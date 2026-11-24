package racinggame.mvc.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    @Test
    @DisplayName("쉼표로 구분한 자동차들이 경주 결과에 포함된다.")
    void 경주_결과에_참가_자동차가_포함된다() {
        RacingGame sut = new RacingGame("pobi,crong,honux", 2, () -> 0);

        RacingResult result = sut.race();

        assertThat(result).isNotNull();
        assertThat(result.getRacers())
            .extracting(Car::getName)
            .containsExactlyInAnyOrder("pobi", "crong", "honux");
        assertThat(result.getWinners()).isEmpty();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    @DisplayName("입력한 횟수만큼 경주를 진행하면 종료된다.")
    void 정해진_횟수만큼_진행하면_종료된다(int tryCount) {
        RacingGame sut = new RacingGame("pobi,crong", tryCount, () -> 0);

        for (int round = 0; round < tryCount; round++) {
            assertThat(sut.isEnd()).isFalse();
            sut.race();
        }

        assertThat(sut.isEnd()).isTrue();
    }

    @Test
    @DisplayName("경주가 끝나면 가장 멀리 간 자동차를 모두 우승자로 반환한다.")
    void 경주가_끝나면_우승자를_반환한다() {
        Iterator<Integer> numbers = List.of(4, 3, 4).iterator();
        RacingGame sut = new RacingGame("pobi,crong,honux", 1, numbers::next);

        RacingResult result = sut.race();

        assertThat(sut.isEnd()).isTrue();
        assertThat(result).isNotNull();
        assertThat(result.getWinners())
            .extracting(Car::getName)
            .containsExactly("pobi", "honux");
    }

    @Test
    @DisplayName("경주가 끝나면 차량을 더 움직일 수 없다.")
    void 종료_후_추가_라운드를_거절한다() {
        Car car = new Car("pobi");
        RacingGame sut = new RacingGame(new Cars(List.of(car)), new RemainingRounds(1), () -> 4);
        sut.race();

        assertThatThrownBy(sut::race).isInstanceOf(IllegalStateException.class);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("같은 횟수 객체를 넘기면 두 경주가 남은 횟수를 공유한다.")
    void 같은_객체로_생성한_경주는_남은_횟수를_공유한다() {
        RemainingRounds rounds = new RemainingRounds(1);
        RacingGame first = new RacingGame(new Cars(List.of(new Car("pobi"))), rounds, () -> 0);
        RacingGame second = new RacingGame(new Cars(List.of(new Car("crong"))), rounds, () -> 0);

        first.race();

        assertThat(first.isEnd()).isTrue();
        assertThat(second.isEnd()).isTrue();
    }
}
