import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRaceTest {
    private CarRace carRace;

    @BeforeEach
    void setUp() {
        carRace = new CarRace();
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"3,5", "4,5"})
    @DisplayName("자동차 대수와 시도할 회수를 순서대로 입력받는 안내문구를 출력하고 입력받는다.")
    void printGuideMessage(int carNumber, int tryCount) {
        String in = String.format("%d%n%d%n", carNumber, tryCount);
        System.setIn(new ByteArrayInputStream(in.getBytes())); //setIn() 이후에 new Scanner(System.in)을 호출해야 동작함.
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        carRace.ready();

        List<String> expected = List.of("자동차 대수는 몇 대 인가요?", "시도할 회수는 몇 회 인가요?");
        assertThat(out.toString()).contains(expected);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"-3,0", "0,0", "3,-1"})
    @DisplayName("자동차 대수와 시도할 회수는 양수여야한다.")
    void throwIfInputPositive(int carNumber, int tryCount) {
        String in = String.format("%d%n%d%n", carNumber, tryCount);
        System.setIn(new ByteArrayInputStream(in.getBytes()));

        assertThatThrownBy(carRace::ready)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(delimiter = ',', value = {"2,2", "4,5", "1,3"})
    @DisplayName("주어진 횟수 동안 자동차는 전진하거나 멈출 수 있으며, 횟수마다 실행 결과를 출력한다.")
    void printStartResult(int carNumber, int tryCount) {
        String in = String.format("%s%n%s%n", carNumber, tryCount);
        System.setIn(new ByteArrayInputStream(in.getBytes()));
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        carRace.ready();

        assertThat(out.toString()).containsPattern("실행 결과\\R((-*\\R)*\\R)*");
    }

//    @RepeatedTest(value = 30)
//    @DisplayName("0에서 9 사이 random 값을 생성한다.")
//    void createRandomBetween() {
//        assertThat(racingCar.createRandom()).isBetween(0, 9);
//    }

//    @ParameterizedTest
//    @CsvSource(delimiter = ':', value = { "0:false", "4:true", "9:true" })
//    @DisplayName("random 값이 4 이상이면 전진하고, 그렇지 않으면 정지한다.")
//    void determineMoveOrNot(int input, boolean expected) {
//        assertThat(racingCar.isGoingForward(input)).isEqualTo(expected);
//    }


}
