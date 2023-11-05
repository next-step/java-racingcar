package ch3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


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
    void 받은_갯수만큼_자동차가_생긴다() {
        carRacing.makingCar(2);
        assertEquals(carRacing.getCars().size(), 2);
        assertEquals(carRacing.getCars().get(0).getClass(), Car.class);
    }


}
