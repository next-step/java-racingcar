package racingcar.domain.car.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 경주 - CarActionStrategyFactory 테스트")
class CarActionStrategyFactoryTest {
    @ParameterizedTest
    @CsvSource(value = {"4|GO_FORWARD", "9|GO_FORWARD", "0|STOP", "1|STOP"}, delimiter = '|')
    void 자동차_이동_전략_팩토리는_4_이상_숫자를_입력하면_이동_전략을_반환한다(int actionNo, CarAction carAction) {
        assertThat(CarActionStrategyFactory.resolve(actionNo).getCarAction()).isEqualTo(carAction);
    }
}
