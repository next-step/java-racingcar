package racingcar.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @DisplayName("승자가 1명 일때 정보를 잘 가져오는 확인")
    @Test
    void getWinnersSingle() {
        List<Car> carList = new ArrayList<Car>() {{
            add(new Car("car1", 3));
            add(new Car("car2", 4));
            add(new Car("car3", 5));
        }};
        Cars cars = new Cars(carList, new TrueFalseRepeatChecker());

        ResultWinners winners = cars.getWinners();

        assertThat(winners).isEqualTo(
            new ResultWinners(
                new ArrayList<String>() {{
                    add("car3");
                }}
            )
        );
    }

    @DisplayName("승자가 여러명 일때 정보를 잘 가져오는지 확인")
    @Test
    void getWinnersMultiple() {
        List<Car> carList = new ArrayList<Car>() {{
            add(new Car("car1", 3));
            add(new Car("car2", 5));
            add(new Car("car3", 5));
        }};
        Cars cars = new Cars(carList, new TrueFalseRepeatChecker());

        ResultWinners winners = cars.getWinners();

        assertThat(winners).isEqualTo(
            new ResultWinners(
                new ArrayList<String>() {{
                    add("car2");
                    add("car3");
                }}
            )
        );
    }
}