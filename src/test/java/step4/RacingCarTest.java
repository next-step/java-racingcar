package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {


    void makeTestInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

//    @DisplayName("입력한 만큼 자동차가 생성되는지 테스트")
//    @Test
//    void createCarTest() {
//        makeTestInput("pobi,crong,honux\n5\n"); // 3대의 자동차와 5회의 경주 입력
//
//        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
//        assertThat(racingCar.getNumberOfCar()).isEqualTo(3);
//        assertThat(racingCar.getNumberOfRace()).isEqualTo(5);
//    }
//
//    @DisplayName("자동차 입력시 글자 수 제한 오류 테스트")
//    @Test
//    void createCarNameErrorTest() {
//        makeTestInput("pobi,cronggggg,honux\n5\n"); // 3대의 자동차와 5회의 경주 입력
//
//        assertThatThrownBy(() ->
//                RacingCarFactory.createRacingCarWithInputView())
//                .isInstanceOf(IndexOutOfBoundsException.class)
//                .isInstanceOf(RuntimeException.class);
//    }

    @DisplayName("전진하는 자동차 출력 시 이름이 잘 출력되는지 테스트")
    @Test
    void moveCarPrintTest() {
        makeTestInput("pobi,crong,honux\n1\n"); // 3대의 자동차와 5회의 경주 입력

        MockOutputView outputView = new MockOutputView();
        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
        racingCar.startRacing(outputView);

        assertTrue(outputView.getOutputs().get(0).contains("pobi"));
        assertTrue(outputView.getOutputs().get(1).contains("crong"));
        assertTrue(outputView.getOutputs().get(2).contains("honux"));
    }

//    @DisplayName("우승자 테스트")
//    @Test
//    void racingWinnerCheckTest() {
//    }
}
