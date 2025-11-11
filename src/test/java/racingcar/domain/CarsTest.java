package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.random.RandomNumber;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @Test
    void 생성자__자동차_이름_크기만큼_자동차를_생성한다() {
        assertThat(new Cars(List.of("자동차하나", "자동차둘")).size()).isEqualTo(2);
    }

    @Test
    void 생성자_자동차_이름_목록_크기가_1_미만이면_예외발생() {
        assertThatThrownBy(() -> new Cars(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 대수는 1이상이어야 합니다.");
    }

    @Test
    void 생성자_자동차_이름_목록에_중복이_있다면_예외발생() {
        assertThatThrownBy(() -> new Cars(List.of("중복", "중복")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다.");
    }

    @Test
    void moveAll_모든_자동차가_이동한다() {
        Cars cars = new Cars(List.of("자동차하나", "자동차둘", "자동차셋"));
        RandomNumber randomNumber = () -> 4;

        cars.moveAll(randomNumber);

        assertThat(cars.toSnapshots())
                .containsExactly(new CarSnapshot("자동차하나", 1), new CarSnapshot("자동차둘", 1), new CarSnapshot("자동차셋", 1));
    }

    @Test
    void moveAll_각_자동차는_서로_다른_랜덤값을_받는다() {
        Cars cars = new Cars(List.of("자동차하나", "자동차둘", "자동차셋", "자동차넷"));
        int[] values = {0, 3, 4, 9};
        int[] index = {0};
        RandomNumber randomNumber = () -> values[index[0]++];

        cars.moveAll(randomNumber);

        assertThat(cars.toSnapshots())
                .containsExactly(
                        new CarSnapshot("자동차하나", 0),
                        new CarSnapshot("자동차둘", 0),
                        new CarSnapshot("자동차셋", 1),
                        new CarSnapshot("자동차넷", 1));
    }

    @Test
    void toSnapShots_자동차_상태_스냅샷_목록을_반환한다() {
        Cars cars = new Cars(List.of("자동차하나", "자동차둘"));
        RandomNumber randomNumber = () -> 4;
        cars.moveAll(randomNumber);

        assertThat(cars.toSnapshots()).containsExactly(new CarSnapshot("자동차하나", 1), new CarSnapshot("자동차둘", 1));
    }
}
