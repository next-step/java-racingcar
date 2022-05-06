package racingCar;

import org.junit.jupiter.api.Test;
import racingCar.view.InputView;

import java.io.ByteArrayInputStream;

import static java.lang.System.lineSeparator;
import static java.lang.System.setIn;
import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    @Test
    void 입력테스트() {
        String userInput = String.format("pobi,crong,honux%s5", lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));

        String[] nameListAnswer = {"pobi", "crong", "honux"};
        String[] nameList = InputView.nameList();

        for (int i = 0; i < nameList.length; i++) {
            assertThat(nameList[i]).isEqualTo(nameListAnswer[i]);
        }
        assertThat(InputView.numberOfGame()).isEqualTo(5);
    }


}
