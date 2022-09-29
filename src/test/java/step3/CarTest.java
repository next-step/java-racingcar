package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    Car car;

    @BeforeEach
    void init(){
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void 파라미터로_moveStrategy를_입력받고_테스트(boolean movable, int position){
        MoveStrategy moveStrategy = ()-> movable;
        car.moveWithStrategy(moveStrategy);
        assertThat(car.getPosition()).isEqualTo(position);
    }


}
