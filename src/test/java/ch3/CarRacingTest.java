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
            assertEquals(inputView, carRacing.getInputView());
            assertEquals(resultView, carRacing.getResultView());
        });
    }

    @Test
    void 받은_이름의_수_만큼_자동차가_생긴다() {
        carRacing.makingCar("pobi,karl");
        assertEquals(carRacing.getCars().size(), 2);
        assertEquals(carRacing.getCars().get(0).getClass(), Car.class);
    }

    @Test
    void 자동차를_받은_갯수만큼_자동차시행숫자가_생긴다() {
        carRacing.makingCar("pobi,karl,evan,david");
        assertAll(() -> {
            assertEquals(carRacing.getExecuteNumbers().size(), 4);
            assertEquals(carRacing.getExecuteNumbers().peek().getClass(), Integer.class);
        });
    }


    @Test
    void 시행하면_랜덤숫자가_변한다() {
        carRacing.makingCar("pobi,karl,evan");
        List<Integer> actual = new ArrayList<>(carRacing.getExecuteNumbers());
        carRacing.executeRace();
        List<Integer> result = new ArrayList<>(carRacing.getExecuteNumbers());
        assertThat(result).isNotEqualTo(actual);
    }

    @Test
    void 경주가_종료하면_우승차가_1명이상이다() {
        carRacing.makingCar("pobi,karl,evan");
        carRacing.executeRace();
        List<Car> winningCars = carRacing.viewResultRaceCars();
        assertFalse(winningCars.isEmpty());

    }


}
