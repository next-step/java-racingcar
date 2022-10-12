package racingcar.winner.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import racingcar.winner.view.CarNameInput;

class CarNameInputTest {

    @Test
    void parse_입력된이름을분리한다() {
        String input = "owen1,owen2,owen3";
        assertThat(new CarNameInput(input).parse()).contains("owen1", "owen2", "owen3");
    }
}