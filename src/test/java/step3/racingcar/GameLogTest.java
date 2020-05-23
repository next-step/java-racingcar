package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racingcar.domain.Car;
import step3.racingcar.domain.GameLog;
import step3.racingcar.domain.RandomMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class GameLogTest {

    @DisplayName("GameLog 정상 생성 테스트")
    @Test
    public void makeGameLogObject() {
        Car car = new Car("car", new RandomMovingStrategy());
        GameLog gameLog = new GameLog(car.getName(), car.getPosition());

        assertThat(gameLog.getCarName()).isEqualTo(car.getName());
        assertThat(gameLog.getCarPosition()).isEqualTo(car.getPosition());
    }
}
