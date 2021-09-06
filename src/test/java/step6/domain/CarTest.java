package step6.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @DisplayName("자동차 이름 5자 이상일 경우 오류 발생 여부 확인")
    @Test
    void carNameLengthErrorTest() {
        Assertions.assertThatThrownBy(() -> {
            new Car("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 이동 로직 테스트 -> 이동")
    @Test
    void moveStrategyTest() {
        Car actual = new Car("a");
        actual.move(new MoveStrategy() {
            @Override
            public boolean move() {
                return true;
            }
        });

        Car expected = new Car("a", 2);
        Assertions.assertThat(actual).isEqualTo(actual);
    }

    @DisplayName("자동차 이동 로직 테스트 -> 정지")
    @Test
    void moveStrategyTest2() {
        Car actual = new Car("a");
        actual.move(new MoveStrategy() {
            @Override
            public boolean move() {
                return false;
            }
        });

        Car expected = new Car("a", 1);
        Assertions.assertThat(actual).isEqualTo(actual);
    }
}