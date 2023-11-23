package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.strategy.MovingStrategy;
import step4.strategy.RandomNumMovingStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("자동차의 이름 개수만큼 자동차를 생성한다.")
    void makeCars() {
        String[] nameArr = {"귤", "자몽", "오렌지"};
        MovingStrategy movingStrategy = new RandomNumMovingStrategy();
        Cars cars = new Cars(nameArr, movingStrategy);

        assertThat(cars.carCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차들 중 가장 많이 이동한 거리 값을 구한다.")
    void findMaxDistance() {
        Cars cars = new Cars(new String[]{"귤", "오렌지", "망고" }, new int[]{1, 3, 1});

        assertThat(cars.findMaxDistance()).isEqualTo(3);
    }
}
