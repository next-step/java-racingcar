package step3;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarRacingTest {

    @Test
    @DisplayName("자동차 대수를 2 이상 10 이하 숫자로 입력받을 수 있다. 그 이외의 숫자를 입력하면 예외를 발생시킨다.")
    public void 자동차_대수_입력() {
        assertThatCode(() -> new CarRacing(2, 1, () -> true))
            .doesNotThrowAnyException();
        assertThatCode(() -> new CarRacing(10, 1, () -> true))
            .doesNotThrowAnyException();
        assertThatThrownBy(() -> new CarRacing(1, 1, () -> true))
            .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new CarRacing(11, 1, () -> true))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("시도할 횟수를 1 이상 10 이하 숫자로 입력받을 수 있다. 그 이외의 숫자를 입력하면 예외를 발생시킨다.")
    public void 시도할_횟수_입력() {
        assertThatCode(() -> new CarRacing(2, 1, () -> true))
            .doesNotThrowAnyException();
        assertThatCode(() -> new CarRacing(2, 10, () -> true))
            .doesNotThrowAnyException();
        assertThatThrownBy(() -> new CarRacing(2, 0, () -> true))
            .isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new CarRacing(2, 11, () -> true))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("시도할 횟수보다 많은 횟수로 자동차를 이동시키려고 하면 예외를 발생시킨다.")
    public void 시도할_횟수() {
        int tryCount = 2;
        CarRacing sut = new CarRacing(2, tryCount, () -> true);

        for (int i = 0; i < tryCount; i++) {
            assertThatCode(sut::racingCars)
                .doesNotThrowAnyException();
        }

        assertThatThrownBy(sut::racingCars)
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력받은 자동차 대수만큼 생성한 자동차를 식별 번호와 함께 리스트로 반환한다.")
    public void 현재_전체_자동차의_상태() {
        List<Car> sut = new CarRacing(2, 1, () -> true).currentCars();

        assertThat(sut).hasSize(2);
    }

    @Test
    @DisplayName("특정 조건은 외부에서 주입받을 수 있다.")
    public void 자동차가_전진할_조건_외부_주입() {
        assertThatCode(() -> new CarRacing(2, 1, new RandomMoveStrategy()))
            .doesNotThrowAnyException();
        assertThatCode(() -> new CarRacing(2, 1, () -> true))
            .doesNotThrowAnyException();
        assertThatThrownBy(() -> new CarRacing(2, 1, null))
            .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("시도할 때마다 전체 자동차(식별번호, 전진한 거리)를 리스트로 반환한다.")
    public void 시도할_때마다_전체_자동차의_상태() {
        int tryCount = 2;
        CarRacing sut = new CarRacing(2, tryCount, () -> true);

        for (int i = 0; i < tryCount; i++) {
            int distance = 1 + i;
            assertThat(sut.racingCars())
                .hasSize(2)
                .allSatisfy(car -> assertThat(car.getDistance()).isEqualTo(distance));
        }
    }
}
