package racing4.application;

import org.junit.jupiter.api.BeforeEach;
import racing4.domain.Race4Car;

import java.util.List;

class Race4ServiceTest {
    List<Race4Car> race4Cars;

    @BeforeEach
    void setUp() {
        race4Cars = List.of(new Race4Car("name1"),
                            new Race4Car("name2"),
                            new Race4Car("name3"));
        race4Cars.get(2).moveForwardByCondition(9);
    }
}
