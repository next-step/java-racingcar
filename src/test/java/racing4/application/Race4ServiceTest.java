package racing4.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing4.domain.Race4Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Race4ServiceTest {
    List<Race4Car> race4Cars;

    @BeforeEach
    void setUp() {
        race4Cars = List.of(new Race4Car("name1"),
                            new Race4Car("name2"),
                            new Race4Car("name3"));
        race4Cars.get(2).moveForwardByCondition(9);
    }

    @Test
    void getWinnerNamesTest() {
        // when
        List<String> winnerNames = Race4Service.getWinnerNames(race4Cars);
        // then
        assertThat(winnerNames).isEqualTo(List.of("name3"));
    }
}
