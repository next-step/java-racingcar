package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCarTest {

    @DisplayName("UI 입력 테스트")
    @Test
    void inputViewTest(){

        String input = "3\n5\n"; // 3대의 자동차와 5회의 경주 입력
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
        assertThat(racingCar.getNumberOfCar()).isEqualTo(3);
        assertThat(racingCar.getNumberOfRace()).isEqualTo(5);
    }

    @DisplayName("UI 입력 오류 테스트")
    @Test
    void inputViewErrorTest(){
        String input = "가\n나\n"; // 3대의 자동차와 5회의 경주 입력
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(()->
                RacingCarFactory.createRacingCarWithInputView())
                .isInstanceOf(InputMismatchException.class)
                .isInstanceOf(RuntimeException.class);
    }
}
