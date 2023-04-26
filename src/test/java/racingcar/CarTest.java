package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Constant;
import racingcar.model.RoundScore;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    private static final String TEST_CAR_NAME = "test";


    @Test
    void 자동차_이동_테스트() {
        {
            Car car = new Car(TEST_CAR_NAME, bound -> 3);
            int before = car.getDistance();
            car.increaseDistance();
            assertThat(car.getDistance()).isEqualTo(before);
        }
        {
            Car car = new Car(TEST_CAR_NAME, bound -> 5);
            int before = car.getDistance();
            car.increaseDistance();
            assertThat(car.getDistance()).isEqualTo(++before);
        }
    }

    @Test
    void 이름은_5글자_초과할_수_없습니다() {
        String overFiveName = "가나다라마";

        assertThatThrownBy(() -> new Car(overFiveName, bound -> 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Constant.Exceptions.NOT_OVER_FIVE_CHARACTER);
    }

    @Test
    void 최대이동거리_테스트() {
        int maxDistance = 4;
        RoundScore roundScore = new RoundScore(TEST_CAR_NAME, maxDistance);

        assertThat(roundScore.hasMaxDistance(maxDistance)).isTrue();
    }

}
