import CarRacing.view.ResultView;
import CarRacing.Car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCarRacingResultView {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("Distance 출력 정상인지 확인")
    public void printCurrentDistance() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("pobi"));
        cars.get(0).move(5);

        System.out.println("== expected > pobi : ------");
        System.out.print(  "== actual   > ");
        ResultView.printCurrentDistance(cars);
    }

    @Test
    @DisplayName("Winner 여러 명 출력 확인")
    public void printWinners_manyWinners() {
        List<String> winners = Arrays.asList("pobi", "crong", "honux");

        String expected = "pobi, crong, honux가 최종 우승했습니다.";
        ResultView.printWinners(winners);

        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(expected);
    }
}
