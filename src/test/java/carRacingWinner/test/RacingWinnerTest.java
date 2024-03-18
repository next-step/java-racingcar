package carRacingWinner.test;

import carRacingWinner.controller.WinnerRacingController;
import carRacingWinner.repository.WinnerRepository;
import carRacingWinner.service.WinnerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingWinnerTest {

    static WinnerService winnerService;
    static WinnerRepository winnerRepository;

    @BeforeAll
    public static void setting() {
        winnerRepository = new WinnerRepository();
        winnerService = new WinnerService(winnerRepository);

    }

    @Test
    @DisplayName("이름 나누기")
    public void nameDivision() {

        String name = "dog,panda,fire";

    }


}