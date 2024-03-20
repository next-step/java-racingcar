package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {

    @Test
    @DisplayName("우승자 선정")
    public void findWinners() {
        //given
        String[] carNamesForWinnerTest = {"poby", "crong", "honux"};
        CarGroup carGroupForWinnerTest = new CarGroup(carNamesForWinnerTest);

        //when, then
        for (int i = 0; i < carGroupForWinnerTest.size(); i++) {
            Assertions.assertThat(carGroupForWinnerTest.carGroup().get(i).name()).isEqualTo(carNamesForWinnerTest[i]);
        }
    }
}
