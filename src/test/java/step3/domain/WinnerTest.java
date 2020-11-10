package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created By mand2 on 2020-11-10.
 */
public class WinnerTest {

    Cars cars;

    @BeforeEach
    void setUp() {
        cars = Cars.of("a,b,c,d");
        cars.getCars().get(0).forward(4);
        cars.getCars().get(1).forward(4);
        cars.getCars().get(2).forward(3);
        cars.getCars().get(3).forward(1);
    }

    @Test
    @DisplayName("동점자가 없는 a 단독 우승")
    public void winner_without_tie_break() {
        cars.getCars().get(0).forward(1);
        assertThat(cars.getWinners()).isEqualTo("a");
    }

    @Test
    @DisplayName("동점자가 있는 우승자")
    public void winner_with_tie_break() {
        assertThat(cars.getWinners()).isEqualTo("a,b");
    }

}
