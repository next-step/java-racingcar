package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    void makeTestInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

//    @DisplayName("UI 입력 테스트")
//    @Test
//    void inputViewTest() {
//        makeTestInput("3\n5\n"); // 3대의 자동차와 5회의 경주 입력
//
//        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
//        assertThat(racingCar.getNumberOfCar()).isEqualTo(3);
//        assertThat(racingCar.getNumberOfRace()).isEqualTo(5);
//    }
//
//    @DisplayName("UI 입력 오류 테스트")
//    @Test
//    void inputViewErrorTest() {
//        makeTestInput("가\n나\n");
//
//        assertThatThrownBy(() ->
//                RacingCarFactory.createRacingCarWithInputView())
//                .isInstanceOf(InputMismatchException.class)
//                .isInstanceOf(RuntimeException.class);
//    }
//
//    @DisplayName("랜덤 난수 발생 테스트")
//    @Test
//    void randomNumberTest() {
//        makeTestInput("3\n5\n");
//
//        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
//        racingCar.generateRandomNumber();
//
//        assertThat(racingCar.generateRandomNumber()).isBetween(0, 9);
//    }
//
//    @DisplayName("랜덤 난수 발생 값에 따른 자동차 이동 테스트")
//    @Test
//    void moveCarTest() {
//        makeTestInput("3\n5\n");
//
//        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
//        racingCar.moveCar();
//
//        assertThat(racingCar.getCarPosition(0)).isIn(0, 1);
//        assertThat(racingCar.getCarPosition(1)).isIn(0, 1);
//        assertThat(racingCar.getCarPosition(2)).isIn(0, 1);
//    }

//    @DisplayName("입력 횟수만큼 자동차가 경주했는지에 대한 테스트")
//    @Test
//    void racingCarTest() {
//        makeTestInput("3\n5\n");
//
//        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
//        racingCar.startRacing();
//
//        assertThat(racingCar.getCarPosition(0)).isBetween(0, 5);
//        assertThat(racingCar.getCarPosition(1)).isBetween(0, 5);
//        assertThat(racingCar.getCarPosition(2)).isBetween(0, 5);
//    }

    @DisplayName("자동차 대수 만큼 결과를 출력했는지 확인하는 테스트")
    @Test
    void resultViewTest() {
        makeTestInput("3\n5\n");
        System.setOut(new PrintStream(outputStreamCaptor));

        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
        racingCar.startRacing();
        RacingCarResultView.printRacingCarStatus(racingCar);

        String output = outputStreamCaptor.toString();

        assertTrue(output.contains("-"));

        long numberOfLines = output.lines().count();
        assertEquals(5, numberOfLines);// input시 줄바꿈 2회 포함 5줄
    }
}
