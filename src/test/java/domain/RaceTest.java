package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @DisplayName("입력받은 차 대수만큼 차를 생성한다")
    @Test
    public void shouldCreateCars_whenInputNumberOfCar() throws Exception {
        //given
        int inputNum = 3;
        List<RacingCar> racingCarList = Race.racingCarList;
        //when
        Race.createCar(inputNum);
        //then
        assertThat(racingCarList.size()).isEqualTo(inputNum);
    }
}
