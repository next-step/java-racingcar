package carracing.view;

import carracing.domain.Car;
import carracing.domain.CarName;
import carracing.domain.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {

    private ByteArrayOutputStream output;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        output = new ByteArrayOutputStream();
        outputView = OutputView.of(new PrintStream(output));
    }

    @ParameterizedTest(name = "자동차 위치 출력 테스트")
    @CsvSource(value = {"한글이름,2", "abc,4", "abcde,5"})
    public void carMoveResultPrintTest(String name, int position) {
        Car car = Car.of(Position.of(position), CarName.of(name));
        outputView.printPosition(car);
        assertThat(output.toString().trim())
                .isEqualTo(String.format("%-5s\t: %s", name, StringUtils.repeat("-", position)));
    }

    @DisplayName("우승자의 이름을 출력한다.")
    @Test
    public void printWinnerTest() {
        List<Car> cars = new ArrayList<>();
        cars.add(Car.of(Position.of(3), CarName.of("car1")));
        cars.add(Car.of(Position.of(3), CarName.of("car2")));
        outputView.printWinners(cars);
        assertThat(output.toString().trim())
                .contains("car1", "car2");
    }

}