package racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingViewTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void printCarNameAskingTest() {
        //given
        RacingView racingView = new RacingView();
        String text = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

        //when
        racingView.printCarNameAsking();

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(text);
    }

    @Test
    void printCountAskingTest() {
        //given
        RacingView racingView = new RacingView();
        String text = "시도할 회수는 몇회인가요?";

        //when
        racingView.printCountAsking();

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(text);
    }

    @Test
    void printCarStatusTest() {
        //given
        RacingView racingView = new RacingView();

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.add(new Car("crong"));
        cars.add(new Car("honux"));

        //when
        racingView.printCarStatus(cars);

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("pobi : -\n" +
                "crong : -\n" +
                "honux : -");
    }

    @Test
    void printWinnersTest() {
        //given
        RacingView racingView = new RacingView();
        List<String> winners = List.of("test1", "test2");

        //when
        racingView.printWinners(winners);

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("test1, test2가 최종 우승했습니다.");
    }

    @Test
    void printResultTitleTest() {
        //given
        RacingView racingView = new RacingView();

        //when
        racingView.printResultTitle();

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("실행 결과");
    }
}