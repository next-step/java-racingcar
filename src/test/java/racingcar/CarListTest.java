package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarListTest {

    @Test
    void Test_extractWinners_succeed() {
        // given
        CarList carList = new CarList(getDummyCars());

        // when
        List<SimpleCar> winners = carList.extractWinners();

        // then
        assertThat(winners).isNotEmpty();
    }

    @Test
    void Test_extractWinners_fail() {
        // given
        CarList carList = new CarList(List.of());

        // when, then
        assertThrows(NoSuchElementException.class, carList::extractWinners);
    }

    private List<SimpleCar> getDummyCars() {
        return List.of("a", "bb", "ccc").stream()
                .map(SimpleCar::new).collect(Collectors.toList());
    }
}
