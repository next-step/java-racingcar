package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewTest {

    InputView inputView = new InputView();

    @ParameterizedTest
    @CsvSource({"-1,false","0,false","1,false","2,true","9,true","10,false"})
    void validateCarCount(int carCount, Boolean expected) {
        //when&then
        assertThat(inputView.validateCarCount(carCount))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"-1,false","0,false","1,false","2,true","9,true","10,false"})
    void validateTime(int time, Boolean expected) {
        //when&then
        assertThat(inputView.validateTime(time))
            .isEqualTo(expected);
    }
}