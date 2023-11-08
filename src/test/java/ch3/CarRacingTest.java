package ch3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;


public class CarRacingTest {

    InputView inputView = new InputView();
    ResultView resultView = new ResultView();
    CarRacing carRacing = new CarRacing(inputView, resultView);

    @Test
    void 자동차_경주는_input_view_result_view를_만들어진다() {
        assertAll(() -> {
            assertEquals(inputView, carRacing.inputView());
            assertEquals(resultView, carRacing.resultView());
        });
    }

    @Test
    void 받은_이름의_수_만큼_자동차가_생긴다() {
        carRacing.makingCar("pobi,karl");
        assertEquals(carRacing.totalCarCount(), 2);
        assertEquals(carRacing.cars().get(0).getClass(), Car.class);
    }

    @Test
    void 자동차를_받은_갯수만큼_자동차시행숫자가_생긴다() {
        carRacing.makingCar("pobi,karl,evan,david");
        assertAll(() -> {
            assertEquals(carRacing.executeNumbersCount(), 4);
            assertEquals(carRacing.executeNumbers().peek().getClass(), Integer.class);
        });
    }


    @Test
    void 시행하면_랜덤숫자가_변한다() {
        carRacing.makingCar("pobi,karl,evan");
        List<Integer> actual = new ArrayList<>(carRacing.executeNumbers());
        carRacing.executeRace();
        List<Integer> result = new ArrayList<>(carRacing.executeNumbers());
        assertThat(result).isNotEqualTo(actual);
    }

    @Test
    void 경주가_종료하면_우승차가_1명이상이다() {
        carRacing.makingCar("pobi,karl,evan");
        carRacing.executeRace();
        List<Car> winningCars = carRacing.getWinningRaceCars();
        assertFalse(winningCars.isEmpty());
    }


}
