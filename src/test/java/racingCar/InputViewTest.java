package racingCar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.lineSeparator;
import static java.lang.System.setIn;
import static org.assertj.core.api.Assertions.*;

public class InputViewTest {
    @Test
    void 입력횟수테스트() {
        String userInput = String.format("3%s5", lineSeparator(), lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));

        InputView inputView = new InputView();

        int numberOfCar = inputView.numberOfCar();
        int numberOfGame = inputView.numberOfGame();

        assertThat(numberOfCar).isEqualTo(3);
        assertThat(numberOfGame).isEqualTo(5);
    }

    @Test
    void 이름입력테스트() {
        String userInput = String.format("pobi,crong,honux%s5", lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));

        InputView inputView = new InputView();
        String[] nameListAnswer = new String[3];
        nameListAnswer[0] = "pobi";
        nameListAnswer[1] = "crong";
        nameListAnswer[2] = "honux";

        String[] nameList = inputView.nameList();
        int numberOfGame = inputView.numberOfGame();

        for (int i = 0; i < nameList.length; i++) {
            assertThat(nameList[i]).isEqualTo(nameListAnswer[i]);
        }
        assertThat(numberOfGame).isEqualTo(5);
    }


}
