package racingcar.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.strategy.MovableNumberGeneratorStrategy;
import racingcar.strategy.NonMovableNumberGeneratorStrategy;
import racingcar.strategy.NumberGeneratorStrategy;
import racingcar.strategy.RandomNumberGeneratorStrategy;

@DisplayName("랜덤 숫자 생성 전략 테스트")
public class RandomNumberGeneratorStrategyTest {

    @DisplayName("랜덤 숫자 전략은 0부터 9까지의 랜덤 숫자를 반환한다")
    @Test
    void generateRandomNumberTest() {
        RandomNumberGeneratorStrategy randomNumberGenerator = new RandomNumberGeneratorStrategy();
        int result = randomNumberGenerator.generateNumber();
        Assertions.assertThat(result).isBetween(0, 9);
    }

    @DisplayName("랜덤 전략은 차가 정지하거나 이동한다")
    @Test
    void 정지_전략_테스트() {
        Car car = new Car();

        car.move(new RandomNumberGeneratorStrategy());
        int point = car.findCarPoint();

        Assertions.assertThat(point).isBetween(0, 1);
    }
}
