package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.strategy.MovingStrategy;
import step4.strategy.RandomNumMovingStrategy;

public class CarsTest {

    @Test
    @DisplayName("자동차의 이름 개수만큼 자동차를 생성한다.")
    void makeCars() {
        String[] nameArr = {"귤", "자몽", "오렌지"};
        MovingStrategy movingStrategy = new RandomNumMovingStrategy();
        Cars cars = new Cars(nameArr, movingStrategy);

        Assertions.assertThat(cars.carCount()).isEqualTo(3);
    }
}
