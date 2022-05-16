package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {

    @Test
    @DisplayName("RacingCars 객체를 만든다.")
    void create_racing_cars() {
        RacingCars rc = RacingCars.create("a,b,c");
        assertThat(rc.getValue().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("RacingCars 객체를 만들 때 이름을 입력하지 않으면 예외가 발생한다.")
    void create_racing_cars_negative_blank() throws Exception {
        assertThatThrownBy(() -> RacingCars.create(""))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("구분자는 ,를 사용해서 이름을 1개 이상 입력해주세요");
    }

    @Test
    @DisplayName("레이싱 게임의 승리자를 추출한다")
    void extract_winner() {
        RacingCars racingCars = new RacingCars(Arrays.asList(new RacingCar("one", new RacingCarPosition(3)),
                new RacingCar("two", new RacingCarPosition(2)),
                new RacingCar("three", new RacingCarPosition(3))));
        racingCars = racingCars.extractWinner();

        RacingCars winnerCars = new RacingCars(Arrays.asList(new RacingCar("one", new RacingCarPosition(3)),
                new RacingCar("three", new RacingCarPosition(3))));

        assertThat(racingCars).isEqualTo(winnerCars);
    }
}
