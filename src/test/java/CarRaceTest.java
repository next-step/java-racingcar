import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRaceTest {

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"3,5", "4,5"})
    @DisplayName("자동차 대수와 시도할 회수를 순서대로 입력받는 안내문구를 출력하고 입력받는다.")
    void printGuideMessage(int carNumber, int tryCount) {
        String in = String.format("%d%n%d%n", carNumber, tryCount);
        System.setIn(new ByteArrayInputStream(in.getBytes())); //setIn() 이후에 new Scanner(System.in)을 호출해야 동작함.
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        InputView inputView = new InputView();
        inputView.getCarCount();
        inputView.getRunCount();

        List<String> expected = List.of("자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?");
        assertThat(out.toString()).contains(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-3\n", "0\n"})
    @DisplayName("자동차 대수는 양수여야한다.")
    void throwIfCarCountPositive(String carCount) {
        System.setIn(new ByteArrayInputStream(carCount.getBytes()));

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::getCarCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0\n", "-1\n"})
    @DisplayName("시도할 회수는 양수여야한다.")
    void throwIfRunCountPositive(String runCount) {
        System.setIn(new ByteArrayInputStream(runCount.getBytes()));

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::getRunCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"2,2", "4,5", "1,3"})
    @DisplayName("자동차 경주를 실행하면, 시도 횟수 동안의 자동차의 위치를 반환한다.")
    void runCarRaceAndGetResult(int carCount, int runCount) {
        CarRace carRace = new CarRace(carCount, runCount);
        List<List<Integer>> result = carRace.run();

        assertThat(result)
                .hasSize(runCount)
                .allMatch(list -> list.size() == carCount);
    }

    @Test
    @DisplayName("자동차 경주의 실행 결과를 출력한다.")
    void printStartResult() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        List<List<Integer>> result = List.of(List.of(1, 2, 3), List.of(1, 2, 3));

        ResultView resultView = new ResultView();
        resultView.print(result);

        assertThat(out.toString()).containsPattern("실행 결과\\R((-*\\R)*\\R)*");
    }

//    @RepeatedTest(value = 30)
//    @DisplayName("0에서 9 사이 random 값을 생성한다.")
//    void createRandomBetween() {
//        assertThat(racingCar.createRandom()).isBetween(0, 9);
//    }

    @Test
    @DisplayName("random 값이 4 이상이면 전진한다.")
    void moveIfUpperMovableValue() {
        Car car = new Car();
        NumberGenerator numberGenerator = () -> 4;
        assertThat(car.move(numberGenerator)).isEqualTo(1);
    }

    @Test
    @DisplayName("random 값이 4 미만이면 정지한다.")
    void stopIfLowerMovableValue() {
        Car car = new Car();
        NumberGenerator numberGenerator = () -> 3;
        assertThat(car.move(numberGenerator)).isEqualTo(0);
    }

}
