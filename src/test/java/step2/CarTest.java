package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car = new Car();

    @Test
    void 자동차가_생성된다() {
        assertThat(car).isNotNull();
    }

    @Test
    void 생성된_자동차의_시작포지션은_0이다() {
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 입력된_숫자만큼_자동차가_생성된다() {
        //TODO: 입력된 숫자만큼 자동차가 생성되는지 테스트 코드 작성
    }

    @Test
    void 자동차는_랜덤숫자가_4이상인_경우만_이동한다() {
        //TODO: 자동차는 랜덤숫자가 4 이상인 경우만 이동하는지 테스트 코드 작성
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 자동차가_이동기준을_통과한_횟수만큼_이동한다(int numberOfMoves) {
        final int aboveMoveCriterionNumber = 5;
        for (int i = 0; i < numberOfMoves; i++) {
            car.move(aboveMoveCriterionNumber);
        }
        assertThat(car.getPosition()).isEqualTo(numberOfMoves);
    }
}
