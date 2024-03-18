package carRacingWinner.test;

import carRacingWinner.controller.WinnerRacingController;
import carRacingWinner.entity.Car;
import carRacingWinner.repository.WinnerRepository;
import carRacingWinner.service.WinnerService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class RacingWinnerTest {

    static WinnerService winnerService;
    static WinnerRepository winnerRepository;

    @BeforeAll
    public static void setting() {
        winnerRepository = new WinnerRepository();
        winnerService = new WinnerService(winnerRepository);

    }

    @Test
    @DisplayName("차 확인")
    public void carCheck() {

        Car car = new Car("sona");

        assertThat(car.getName()).isEqualTo("sona");
        car.move();
        car.move();
        car.move();

        assertThat(car.getLocation()).isEqualTo(3);
    }
}