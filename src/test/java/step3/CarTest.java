package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("4이상이동거리가 인 경우 이동한다.")
    void add_move_distance(int input) {
        //when
        car.moveForward(input);
        int getMoveDistance = car.getMoveDistance();

        //then
        assertThat(getMoveDistance).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("3 이하인 경우 이동하지 않는다.")
    void add_move_status(int input) {
        //when
        car.moveForward(input);
        int getMoveDistance = car.getMoveDistance();

        //then
        assertThat(getMoveDistance).isEqualTo(0);
    }
}