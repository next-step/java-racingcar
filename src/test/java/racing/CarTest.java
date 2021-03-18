package racing;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.exception.CarNameException;

class CarTest {

    private Car car;

    @BeforeEach
    void setup(){
        car = new Car("pobi", 0);
    }
    
    @DisplayName("4 초과 이동하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5,6})
    public void successMoveTest(int number){
        car.tryMove(number);
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @DisplayName("3 이하는 이동하지 않는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    public void failMoveTest(int number){
        car.tryMove(number);
        assertThat(car.getMoveCount()).isEqualTo(0);
    }

    @DisplayName("car name null 체크")
    @ParameterizedTest
    @ValueSource(strings = {""})
    public void nullNameExceptionTest(String value){
        assertThatThrownBy(() -> new Car(value, 0))
            .isInstanceOf(CarNameException.class);
    }

    @DisplayName("car name 글자 초과 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123456"})
    public void maxLengthExceptionTest(String value){
        assertThatThrownBy(() -> new Car(value, 0))
            .isInstanceOf(CarNameException.class);
    }
}
