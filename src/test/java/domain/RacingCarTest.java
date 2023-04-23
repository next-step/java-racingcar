package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    public void setUp() {
        racingCar = new RacingCar();
    }

    @Test
    public void shouldGoOneStep() throws Exception {
        //when
        racingCar.moveOrStop(()-> true);
        //then
        assertThat(racingCar.getDistance()).isEqualTo(1);
    }
    @Test
    public void shouldStop() throws Exception {

        //when
        racingCar.moveOrStop(()->false);
        //then
        assertThat(racingCar.getDistance()).isEqualTo(0);
    }

    @DisplayName("입력받은 이름에 대해 차를 생성하고 이름을 부여할 수 있다.")
    @Test
    public void shouldNameAndCreateCar_whenInputName() throws Exception {
        //given
        String name = "name";
        //when
        RacingCar car = new RacingCar(name);
        //then
        assertThat(car.getName()).isEqualTo(name);
    }


}

