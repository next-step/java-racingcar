package carRacingWinner.test;

import carRacingWinner.controller.WinnerRacingController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingWinnerTest {

    @Test
    @DisplayName("이름 나누기")
    public void nameDivision() {

        String name = "dog,panda,fire";
        WinnerRacingController namesCheck = new WinnerRacingController();

        assertThat(namesCheck.division(name)).hasSize(3);
    }

}