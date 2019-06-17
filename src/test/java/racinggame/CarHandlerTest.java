package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarHandlerTest {
    @Test
    void 숫자가_4이상인_경우에만_true_반환() {
        Assertions.assertThat(CarHandler.isMoveCondition(0)).isFalse();
        Assertions.assertThat(CarHandler.isMoveCondition(1)).isFalse();
        Assertions.assertThat(CarHandler.isMoveCondition(2)).isFalse();
        Assertions.assertThat(CarHandler.isMoveCondition(3)).isFalse();
        Assertions.assertThat(CarHandler.isMoveCondition(4)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(5)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(6)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(7)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(8)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(9)).isTrue();
        Assertions.assertThat(CarHandler.isMoveCondition(10)).isTrue();
    }

    @Test
    void 숫자가_최소_최대값을_벗어나면_오류() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarHandler.isMoveCondition(CarHandler.MIN_RANDOM_INTEGER - 1));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> CarHandler.isMoveCondition(CarHandler.MAX_RANDOM_INTEGER + 1));
    }

    /*
    1. getRandomInt 메서드는 자바에서의 random.nextInt() 메서드를 테스트하는 격이 되는데, 그래도 테스트 코드가 필요한지 궁금합니다.

    2. getRandomMoveCondition 메서드는 단순히 getRandomInt 의 결과를 isMoveCondition 메서드에 넣어서 boolean 을 반환하는 메서드입니다.
       isMoveCondition 메서드는 위에서 테스트가 완료되었고, 만약 getRandomInt 에 대한 테스트도 있다면,
       이 getRandomMoveCondition 메서드에 대한 테스트는 생략해도 되는지 궁금합니다.
     */
}
