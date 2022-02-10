package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {

    private MoveRule moveRule;
    private Car car;

    @BeforeEach
    void setUp() {
        moveRule = new MoveRule(4);
    }

    @Test
    void 자동차_이름이_5글자_이상_에러() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Car("포르쉐입니다", moveRule))
            .withMessage("[ERROR] 자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 이동전략에_따라_이동을_판단한다() {
        car = new Car("포르쉐", 0 ,new MoveRule(4));
        car.moveByRule(5);
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
