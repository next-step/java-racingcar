package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.view.InputView;
import step3.model.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarRacingTest {

    @ParameterizedTest
    @ValueSource(strings ={" ",""})
    void 공백_예외(String input){
        assertThatThrownBy(()->{
             InputView.inputCome();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공백은 안되요");
    }


    @Test
    void doRacing(){

    }

    @Test
    void resultShow(){

    }

    @ParameterizedTest
    @ValueSource(ints={4,6,8})
    @DisplayName("이동하는 경우")
    void 이동하는경우(int randomValue){
        Car car =new Car();
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints={-1,3,2})
    @DisplayName("정지하는 경우")
    void 정지하는경우(int randomValue){
        Car car = new Car();
        car.move(randomValue);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
