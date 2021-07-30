package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "4:true", "5:true"}, delimiter = ':')
    @DisplayName("4이상인지 아닌지 판별한다.")
    void check_possible_moving(int input, boolean expected) {

        boolean result = car.checkProgressPossible(input);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동거리가 늘어나는지 테스트한다.")
    void add_move_distance() {
        //given
        int expected = 1;
        car.addMoveDistance();

        //when
        int getMoveDistance = car.getMoveDistance();

        //then
        assertThat(getMoveDistance).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동거리 상태가 늘어나는지 테스트한다.")
    void add_move_status() {
        //given
        String expected = "-";
        car.updateMoveStatus();

        //when
        String getMoveStatus = car.getMoveStatus();

        //then
        assertThat(getMoveStatus).isEqualTo(expected);
    }
}