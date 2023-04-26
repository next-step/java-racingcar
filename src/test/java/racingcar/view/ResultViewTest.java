package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {


    @Test
    @DisplayName("repeat 함수 동작 테스트")
    void multiple_position_draw_check(){

        String DASH = "-";

        assertThat(DASH.repeat(0)).isEqualTo("");
        assertThat(DASH.repeat(1)).isEqualTo("-");
        assertThat(DASH.repeat(2)).isEqualTo("--");
        assertThat(DASH.repeat(3)).isEqualTo("---");
    }



    @Test
    @DisplayName("우승자 출력 메세지 동작 테스트")
    void check_print_winner_message(){
        Cars cars = new Cars();
        cars.addCar("test1");
        cars.addCar("test2");
        cars.addCar("test3");

        // test1, test2, test3 모두 position 값이 0 이므로 winners 에 모두 포함한다.
        assertThat(cars.getWinners())
                .contains("test1")
                .contains("test2")
                .contains("test3");
    }
}
