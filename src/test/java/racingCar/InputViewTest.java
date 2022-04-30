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
    void 입력횟수테스트(){
        String userInput = String.format("3%s5", lineSeparator(), lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));

        InputView inputView = new InputView();

        int numberOfCar =  inputView.numberOfCar();
        int numberOfGame = inputView.numberOfGame();

        assertThat(numberOfCar).isEqualTo(3);
        assertThat(numberOfGame).isEqualTo(5);
    }

    @Test
    void 이름입력테스트(){
        String userInput = String.format("pobi,crong,honux%s5", lineSeparator());
        setIn(new ByteArrayInputStream(userInput.getBytes()));

        InputView inputView = new InputView();
        List<String> nameListAnswer = new ArrayList<>();
        nameListAnswer.add("pobi");
        nameListAnswer.add("crong");
        nameListAnswer.add("honux");

        List<String> nameList =  inputView.nameList();
        int numberOfGame = inputView.numberOfGame();

        for(int i=0; i<nameList.size(); i++){
            assertThat(nameList.get(i)).isEqualTo(nameListAnswer.get(i));
        }

        assertThat(numberOfGame).isEqualTo(5);

    }


}
