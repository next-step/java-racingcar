package carracing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("자동차를 위한 테스트")
class CarTest {

    private static final int ONE = 1;
    private static final int INITIATION_POSITION_NUMBER = 0;
    private static final int POLICY_BASE_NUMBER = RandomIntMovementPolicy.getPolicyBaseNumber();
    private static final int MOVABLE_POSITION_NUMBER = POLICY_BASE_NUMBER;
    private static final int UNMOVABLE_POSITION_NUMBER = MOVABLE_POSITION_NUMBER - ONE;

    private RandomGenerator randomGenerator;
    private MovementPolicy movementPolicy;

    @BeforeEach
    void setUp() {
        randomGenerator = mock(RandomGenerator.class);
        movementPolicy = new RandomIntMovementPolicy(randomGenerator);
    }

    @DisplayName("정상적인 자동차 생성 확인")
    @Test
    void createCarTest() {
        // When
        Car car = new Car();

        // Then
        assertAll(
                () -> assertThat(car).isNotNull(),
                () -> assertThat(car.getPosition().getNumber()).isEqualTo(INITIATION_POSITION_NUMBER)
        );
    }

    @DisplayName("자동차가 움직일 수 있는 경우, 자동자의 위치가 변경되는지 확인")
    @Test
    void moveCarTest() {
        // When
        Car car = new Car();
        when(randomGenerator.generateZeroToNineInt())
                .thenReturn(MOVABLE_POSITION_NUMBER);
        car.move(movementPolicy);

        // Then
        assertThat(car.getPosition().getNumber()).isEqualTo(ONE);
    }

    @DisplayName("자동차가 움직일 수 있는 경우, 자동자의 위치가 변경되는지 확인")
    @Test
    void checkMoveCarTest() {
        // When
        Car car = new Car();
        when(randomGenerator.generateZeroToNineInt())
                .thenReturn(UNMOVABLE_POSITION_NUMBER);
        car.move(movementPolicy);

        // Then
        assertThat(car.getPosition().getNumber()).isEqualTo(INITIATION_POSITION_NUMBER);
    }
}
