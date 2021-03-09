package racing_game;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing_game.domain.Car;

class CarTest {

    private Car car;

    @BeforeEach
    void setup(){
        car = new Car("pobi");
    }
    @DisplayName("4 이상 이동하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6})
    public void successMoveTest(int number){
        car.tryMove(number);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("4 이하는 이동하지 않는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void failMoveTest(int number){
        car.tryMove(number);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @DisplayName("car name null 체크")
    @ParameterizedTest
    @ValueSource(strings = {""})
    public void nullNameExceptionTest(String value){
        assertThatThrownBy(() -> new Car(value))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("car name 글자 초과 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    public void maxLengthExceptionTest(String value){
        assertThatThrownBy(() -> new Car(value))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
