package ch3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarRacingTest {

    @Test
    void 자동차_경주는_input_view_result_view를_만들어진다() {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        CarRacing carRacing = new CarRacing(inputView, resultView);
        assertEquals(inputView, carRacing.getInputView());
        assertEquals(resultView, carRacing.getResultView());
    }

}
