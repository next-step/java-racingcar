package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.view.RacingGameInputView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameControllerTest {
    private static RacingGameController rgc;
    private static InputStream in;

//    @BeforeAll
//    static void initAll() {
//        rgc = new RacingGameController();
//    }

    @Test
    void setCarsNameTest() {
        rgc = new RacingGameController("pobi,woni,jun",5);

        ArrayList<RacingCar> cars = rgc.getCars();

        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    void findTwoWinnerTest() {
        rgc = new RacingGameController("pobi,woni,jun",5);

        rgc.getCars().get(0).setStatus(5);
        rgc.getCars().get(1).setStatus(2);
        rgc.getCars().get(2).setStatus(5);
        List<String> answer = new ArrayList<>();
        answer.add("pobi");
        answer.add("jun");
        rgc.findWinnerWithMaxStatus(5);
        assertThat(rgc.getWinners()).isEqualTo(answer);

    }

    @DisplayName("잘못된 자동차 이름 입력에 대한 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {",,,", ", , ,", "a, b, ,"})
    void wrongCarsNameInputTest(String input) {
        assertThat(InputValidator.checkCarsNameInput(input)).isEqualTo(false);
    }

    @DisplayName("잘못된 라운드 입력에 대한 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"WOW!!", "??", "abc"})
    void wrongRoundNumberInputTest(String input) {
        assertThat(InputValidator.checkRoundNumberInput(input)).isEqualTo(false);
    }

}
