package racing_car_with_winner.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarNameInputTest {

    @Test
    void parse_입력된이름을분리한다() {
        String input = "owen1,owen2,owen3";
        Assertions.assertThat(new CarNameInput(input).parse()).contains("owen1", "owen2", "owen3");
    }
}