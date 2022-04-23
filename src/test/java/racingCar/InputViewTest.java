package racingCar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static java.lang.System.lineSeparator;
import static java.lang.System.setIn;
import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @Test
    void 입력횟수테스트(){
        String userInput = String.format("3%s5", lineSeparator(), lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));

        InputView inputView = new InputView();

        int numberOfCar =  inputView.numberOfCar();
        int numberOfGame = inputView.numberOfGame();

        assertThat(numberOfCar).isEqualTo(3);
        assertThat(numberOfGame).isEqualTo(5);
    }


}
