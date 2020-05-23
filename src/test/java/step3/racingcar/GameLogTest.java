package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.racingcar.domain.Car;
import step3.racingcar.domain.RandomMovingStrategy;

public class GameLogTest {

    @DisplayName("GameLog 정상 생성 테스트")
    @Test
    public void makeGameLogObject() {
        Car car = new Car("car", new RandomMovingStrategy());
        GameLog gameLog = new GameLog(car.getName(), car.getPosition());

        assertThat(gameLog.getName()).isEqualTo(car.getName());
        assertThat(gameLog.getPostion()).isEqualTo(car.getPosition());
    }
}
