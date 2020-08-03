package racingcar.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;
import resource.StringResources;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String NAME_OF_CAR = "TEST";
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("게임 시작 문자열 출력 테스트")
    @Test
    void printStartTest() {
        ResultView.printStart();
        printMessageTest(StringResources.GAME_RESULT + "\n");
    }

    @DisplayName("전진한 자동차 출력 테스트")
    @Test
    void printMoveCarTest() {

        Car car = new Car(NAME_OF_CAR);
        car.moveAndStop(5);
        ResultView.printResult(car);
        printMessageTest(NAME_OF_CAR + " : --\n");
    }

    @DisplayName("정지한 자동차 출력 테스트")
    @Test
    void printStopCarTest() {
        Car car = new Car(NAME_OF_CAR);
        car.moveAndStop(1);
        ResultView.printResult(car);
        printMessageTest(NAME_OF_CAR + " : -\n");
    }

    @DisplayName("라인 피드 테스트")
    @Test
    void lineFeedTest() {
        ResultView.lineFeed();
        printMessageTest("\n");
    }

    @DisplayName("우승자 출력 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "a, b", "c, d" })
    public void printWinnerNamesTest(String winnerNames) {
        ResultView.printWinnerNames(winnerNames);
        printMessageTest(winnerNames + StringResources.GAME_RESULT_WINNERS + "\n");
    }



    private void printMessageTest(String testMessage) {
        assertThat(testMessage).isEqualTo(outContent.toString());
    }
}
