package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RacingcarTest {

    @BeforeEach
    void setUp(){
        RacingGameMain racingGameMain = new RacingGameMain();
    }

    @DisplayName("입력한 자동차 이름이 5자를 넘어갈 수 없다.")
    @Test
    void nameCheckTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Car car = new Car("poby123");
        });
    }

    @DisplayName("0~9사이의 무작위 값을 뽑아 4이상이면 자동차를 움직일 수 있다")
    @Test
    void isMoveTest(){
        Car car = new Car("poby");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

}
