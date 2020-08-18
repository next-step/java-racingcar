package racing.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarsTest {

    @Test
    @DisplayName("우승자 이름 테스트")
    void getNameOfWinner() {
        // given
        String nameOfWinner = "test1";
        Car winner = new Car(nameOfWinner);
        winner.move(() -> true);

        Cars cars = new Cars(Arrays.asList(
                winner,
                new Car("test2"),
                new Car("test3")
        ));
        cars.nextTrial(() -> false);

        // when
        List<String> actual = cars.getNamesOfWinners();

        // then
        List<String> expected = Arrays.asList(nameOfWinner);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("공통 우승자 이름 테스트")
    void getNamesOfWinners() {
        // given
        Cars cars = new Cars(Arrays.asList(
                new Car("test1"),
                new Car("test2"),
                new Car("test3")
        ));
        cars.nextTrial(() -> true);

        // when
        List<String> actual = cars.getNamesOfWinners();

        // then
        List<String> expected = Arrays.asList("test1", "test2", "test3");
        assertEquals(expected, actual);
    }
}
