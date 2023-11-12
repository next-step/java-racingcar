package racing4.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing4.domain.Race4Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Race4ServiceTest {
    Race4Service race4Service;

    @BeforeEach
    void setUp() {
        List<Race4Car> race4Cars = List.of(new Race4Car("name1"),
                                           new Race4Car("name2"),
                                           new Race4Car("name3"));
        race4Cars.get(0).setPosition(1);
        race4Cars.get(1).setPosition(2);
        race4Cars.get(2).setPosition(3);
        race4Service = new Race4Service(race4Cars, 3);
    }

    @Test
    void getWinnerNamesTest() {
        // when
        List<String> winnerNames = race4Service.getWinnerNames();
        // then
        assertThat(winnerNames).isEqualTo(List.of("name3"));
    }
}
