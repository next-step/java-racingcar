package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private MoveRule testMoveRule;
    private Car car;

    @BeforeEach
    void setUp() {
        testMoveRule = () -> true;
    }

    @Test
    void 자동차_이름이_5글자_이상_에러() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Car("포르쉐입니다", testMoveRule))
            .withMessage("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 이동전략에_따라_이동을_판단한다() {
        car = new Car("포르쉐", 0, testMoveRule);
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
