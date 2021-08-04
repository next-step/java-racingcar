package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import step4.view.InputView;

import static org.junit.jupiter.api.Assertions.*;

public class CarRacingTest {
    @Test
    @DisplayName("이름을 5자 이상 입력하면 안된다.")
    public void should_not_inserted_over_5() {
        //given
        String carNames = "carcarcar";

        //when
        InputView view = new InputView();

        //then
        assertTrue(view.isOverLength(carNames));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름 null 또는 빈문자열이 들어오면 안된다.")
    public void should_return_false_for_null_and_empty_strings(String input) {
        //when
        InputView view = new InputView();

        //then
        assertTrue(view.isBlank(input));
    }

    @Test
    @DisplayName("차 이름을 분리해서 세팅한다.")
    public void set_car_name() {
        //given
        String carName = "car1,car2,car3";
        String[] expect = {"car1", "car2", "car3"};

        //when
        InputView view = new InputView();
        String[] names = view.splitName(carName);

        //then
        for (int i=0; i<names.length; i++) {
            assertEquals(expect[i], names[i]);
        }
    }


}
