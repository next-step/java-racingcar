package racingcarwinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarwinnerexception.NameOutOfLengthException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputViewTest {

    InputView inputView = new InputView();

    @DisplayName("5글자 이상의 자동차 이름이 입력된 경우 예외처리")
    @Test
    void NameLengthDiscriminationTest(){
        assertThatExceptionOfType(NameOutOfLengthException.class).isThrownBy(()->inputView.NameLengthDiscrimination("scoopsoup"));
    }
}
