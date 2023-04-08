package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 자동차 테스트")
class CarTest {
    private final static long SEED = 42;
    private final static int MAX_RANDOM_REPEAT = 10;

    private Car car;
    private Random random;

    @BeforeEach
    public void reset() {
        car = new Car(SEED);
        random = new Random(SEED);
    }
    
    @DisplayName("랜덤 값이 4 이상일 경우 자동차는 움직여야 한다")
    @RepeatedTest(MAX_RANDOM_REPEAT)
    public void go() {
        int expected = random.nextInt(10);
        CarStatus status = car.move();

        if (expected >= 4) {
            assertThat(status).isEqualTo(CarStatus.RUN);
        }
    }

    @DisplayName("랜덤 값이 4 미만일 경우 자동차는 움직여선 안된다")
    @RepeatedTest(MAX_RANDOM_REPEAT)
    public void stop() {
        int expected = random.nextInt(10);
        CarStatus status = car.move();

        if (expected < 4) {
            assertThat(status).isEqualTo(CarStatus.STOP);
        }
    }

    @DisplayName("움직인다면 최대 1만큼만 움직여야 한다")
    @RepeatedTest(MAX_RANDOM_REPEAT)
    public void goOneStep() {
        CarStatus status = car.move();

        if (status == CarStatus.RUN) {
            int distance = car.distance();
            assertThat(distance).isEqualTo(1);
        }
    }
}