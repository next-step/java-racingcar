package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.policy.MovePolicy;
import racingcar.random.RandomNumberGenerator;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {

    @Test
    void 생성자_자동차_이름_목록대로_자동차가_생성된다() {
        Cars cars = new Cars(List.of("자동차하나", "자동차둘"));

        assertThat(cars.toSnapshots()).extracting(CarSnapshot::name).containsExactly("자동차하나", "자동차둘");
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
    void moveAll_모든_자동차에게_이동_메시지를_전달한다() {
        Cars cars = new Cars(List.of("자동차하나", "자동차둘", "자동차셋"));
        RandomNumberGenerator generator = () -> new RandomNumber(4);
        MovePolicy movePolicy = (randomNumber) -> true;

        cars.moveAll(generator, movePolicy);

        assertThat(cars.toSnapshots()).hasSize(3);
    }
}
