package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {
    @Test
    void getNameOfCars() {
        assertThat(InputView.getNameOfCars(" ABC, DEF ,GHIJ")).containsExactly("ABC", "DEF", "GHIJ");
        assertThat(InputView.getNameOfCars(" , ABC ,DEF")).containsExactly("ABC", "DEF");
    }

    @Test
    void isValidInputOfCars(String input, boolean expected) {
        assertThat(InputView.isValidInputOfCars("ABC, DEF, GHI, J")).isEqualTo(true);
        assertThat(InputView.isValidInputOfCars(" ")).isEqualTo(false);
        assertThat(InputView.isValidInputOfCars("")).isEqualTo(false);
        assertThat(InputView.isValidInputOfCars(" ,")).isEqualTo(false);
    }
}