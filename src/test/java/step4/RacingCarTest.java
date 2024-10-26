package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.RacingCar;
import step4.domain.RacingCarFactory;
import step4.view.MockOutputView;
import step4.view.RacingCarInputView;
import step4.view.RacingCarResultView;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {


    void makeTestInput(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        RacingCarInputView.initiateScanner();
    }

    @DisplayName("입력한 만큼 자동차가 생성되는지 테스트")
    @Test
    void createCarTest() {
        makeTestInput("pobi,crong,honux\n5\n"); // 3대의 자동차와 5회의 경주 입력

        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
        assertThat(racingCar.getNumberOfCar()).isEqualTo(3);
        assertThat(racingCar.getNumberOfRace()).isEqualTo(5);
    }

    @DisplayName("자동차 입력시 글자 수 제한 오류 테스트")
    @Test
    void createCarNameErrorTest() {
        makeTestInput("pobi,cronggggg,honux\n5\n"); // 3대의 자동차와 5회의 경주 입력

        assertThatThrownBy(() ->
                RacingCarFactory.createRacingCarWithInputView())
                .isInstanceOf(IndexOutOfBoundsException.class)
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("전진하는 자동차 출력 시 이름이 잘 출력되는지 테스트")
    @Test
    void moveCarPrintTest() {
        makeTestInput("pobi,crong,honux\n1\n"); // 3대의 자동차와 5회의 경주 입력

        MockOutputView outputView = new MockOutputView();
        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();
        outputView.startAndPrintRacing(racingCar);

        assertTrue(outputView.getOutputs().get(0).contains("pobi"));
        assertTrue(outputView.getOutputs().get(1).contains("crong"));
        assertTrue(outputView.getOutputs().get(2).contains("honux"));
    }

    @DisplayName("우승자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,5,7,1,1,1=crong,honux", "7,1,1,1,1,1=pobi", "9,9,9,1,1,1=pobi,crong,honux"}, delimiter = '=')
    void racingWinnerCheckTest(String input, String expected) {

        makeTestInput("pobi,crong,honux\n1\n");

        MockOutputView outputView = new MockOutputView();
        RacingCar racingCar = RacingCarFactory.createRacingCarWithInputView();

        String[] stringArray = input.split(",");
        int[] inputList = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            inputList[i] = Integer.parseInt(stringArray[i]);
        }

        int i = 0;

        while (i < stringArray.length) {
            racingCar.moveCar(inputList[i++], 0);
            racingCar.moveCar(inputList[i++], 1);
            racingCar.moveCar(inputList[i++], 2);
            RacingCarResultView.printRacingCarStatus(outputView, racingCar);
        }
        RacingCarResultView.printRacingCarWinner(outputView, racingCar);

        String[] resultArray = expected.split(",");

        ArrayList<String> outputList = outputView.getOutputs();
        String lastOutput = outputList.get(outputView.getOutputs().size() - 1);

        assertTrue(Arrays.stream(resultArray).allMatch(lastOutput::contains));
    }
}
