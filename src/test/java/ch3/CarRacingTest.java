package ch3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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

    @Test
    void 자동차를_받은_갯수만큼_자동차시행숫자가_생긴다() {
        carRacing.makingCar(4);
        assertAll(() -> {
            assertEquals(carRacing.getExecuteNumbers().size(), 4);
            assertEquals(carRacing.getExecuteNumbers().peek().getClass(), Integer.class);
            // TODO - 질문 > 이거 오류가 나는데, 왜 나는지 궁금합니다. java.lang.Class로 잡혀서요 상위 상속을 먼저 잡는거 때문일까요?
//            assertInstanceOf(carRacing.getExecuteNumbers().get(0).getClass(), Integer.class);
        });
    }


    @Test
    void 시행하면_랜덤숫자가_변한다() {
        carRacing.makingCar(3);
        List<Integer> actual = new ArrayList<>(carRacing.getExecuteNumbers());
        carRacing.executeRace();
        List<Integer> result = new ArrayList<>(carRacing.getExecuteNumbers());
        assertThat(result).isNotEqualTo(actual);
    }


}
