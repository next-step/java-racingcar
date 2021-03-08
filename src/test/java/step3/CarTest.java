package step3;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    private Car car;

    @BeforeEach
    void setup(){
        car = new Car();
    }
    @DisplayName("4 이상 이동하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4,5,6})
    public void successMoveTest(int number){
        car.tryMove(number);
        assertThat(car.getCount()).isEqualTo(1);
    }

    @DisplayName("4 이하는 이동하지 않는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    public void failMoveTest(int number){
        car.tryMove(number);
        assertThat(car.getCount()).isEqualTo(0);
    }
}
