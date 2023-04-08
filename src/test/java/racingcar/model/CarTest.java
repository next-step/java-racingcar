package racingcar.model;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 자동차 테스트")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // seed 순서대로 나와야 하므로 병렬로 실행되면 안됨
class CarTest {
    private final static long SEED = 42;
    private final static int MAX_RANDOM_REPEAT = 10;

    private Car car;
    private Random random;

    @BeforeAll
    public void reset() {
        random = new Random(SEED);
        car = new Car(SEED);
    }

    @Order(1)
    @RepeatedTest(MAX_RANDOM_REPEAT)
    @DisplayName("랜덤 값이 4 이상일 경우 자동차는 움직여야 한다")
    public void go() {
        int expected = random.nextInt(10);
        CarStatus status = car.move();

        if (expected >= 4) {
            assertThat(status).isEqualTo(CarStatus.RUN);
        }
    }

    @Order(1)
    @RepeatedTest(MAX_RANDOM_REPEAT)
    @DisplayName("랜덤 값이 4 미만일 경우 자동차는 움직여선 안된다")
    public void stop() {
        int expected = random.nextInt(10);
        CarStatus status = car.move();

        if (expected < 4) {
            assertThat(status).isEqualTo(CarStatus.STOP);
        }
    }

    @Order(2)
    @RepeatedTest(MAX_RANDOM_REPEAT)
    @DisplayName("움직인다면 1만큼만 움직여야 한다")
    public void goOneStep() {
        int prevDistance = car.distance();
        CarStatus status = car.move();

        if (status == CarStatus.RUN) {
            int distance = car.distance();
            assertThat(distance).isEqualTo(prevDistance + 1);
        }
    }
}