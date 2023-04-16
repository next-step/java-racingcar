package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @DisplayName("입력받은 이름에 대해 차를 생성하고 이름을 부여할 수 있다.")
    @Test
    public void shouldNameAndCreateCars() throws Exception {
        //given
        String[] nameList = {"Tom", "Jerry", "Pinch"};
        //when
        Race.createCars(nameList);
        //then
        for (RacingCar racingCar : Race.racingCarList) {
            assertThat(racingCar.getName()).isIn(nameList);
        }
    }

    @DisplayName("자동차 이름이 5자를 초과하면 게임이 종료된다.")
    @Test
    public void shouldTerminateGame_whenExceed() throws Exception {
        //given
        String[] nameList = {"Tomass", "Jerry", "Pinch"};
        //when & then
        assertThatThrownBy(() -> {
            Race.createCars(nameList);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
