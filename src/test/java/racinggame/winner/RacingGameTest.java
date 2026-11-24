package racinggame.winner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest {

    @Test
    @DisplayName("차량마다 주입된 숫자를 하나씩 사용하고 정해진 횟수만큼 진행하면 경주가 끝난다.")
    void 라운드_진행과_경주_종료() {
        Car first = new Car("car1");
        Car second = new Car("car2");
        Iterator<Integer> numbers = List.of(3, 4, 4, 3).iterator();
        RacingGame sut = new RacingGame(new Cars(List.of(first, second)), new RacingCount(2), numbers::next);

        assertThat(sut.isFinish()).isFalse();

        sut.race();

        assertThat(first.getPosition()).isEqualTo(1);
        assertThat(second.getPosition()).isEqualTo(2);
        assertThat(sut.isFinish()).isFalse();

        sut.race();

        assertThat(first.getPosition()).isEqualTo(2);
        assertThat(second.getPosition()).isEqualTo(2);
        assertThat(sut.isFinish()).isTrue();
    }

    @Test
    @DisplayName("경주가 끝난 뒤 라운드를 진행하면 차량 이동 없이 예외가 발생한다.")
    void 종료_후_추가_시도() {
        Car car = new Car("car1");
        RacingGame sut = new RacingGame(new Cars(List.of(car)), new RacingCount(1), () -> 4);
        sut.race();

        assertThatThrownBy(sut::race).isInstanceOf(IllegalStateException.class);
        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자 생성기를 지정하지 않아도 기본 난수 생성기로 라운드를 진행한다.")
    void 기본_난수_생성기로_라운드_진행() {
        Car car = new Car("car1");
        RacingGame sut = new RacingGame(new Cars(List.of(car)), new RacingCount(1));

        sut.race();

        assertThat(car.getPosition()).isBetween(1, 2);
        assertThat(sut.isFinish()).isTrue();
    }

    @Test
    @DisplayName("경주 중에도 선두를 조회할 수 있고, 동점이면 모든 선두 차량을 반환한다.")
    void 단독_선두와_공동_선두_조회() {
        Car first = new Car("car1", 2);
        Car second = new Car("car2");
        Car third = new Car("car3");
        Iterator<Integer> numbers = List.of(3, 4, 3).iterator();
        RacingGame sut = new RacingGame(new Cars(List.of(first, second, third)), new RacingCount(1), numbers::next);

        assertThat(sut.getWinners()).containsExactly(first);

        sut.race();

        assertThat(sut.getWinners()).containsExactlyInAnyOrder(first, second);
    }
}
