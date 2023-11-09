package car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IoMainTest {

    private List<Car> cars = new ArrayList<Car>();
    private List<Car> dupleWinners = new ArrayList<Car>();

    @BeforeEach
    void setCars() {
        cars.add(new Car("pobi", 3));
        cars.add(new Car("crong", 5));
        cars.add(new Car("honux", 6));

        dupleWinners.add(new Car("pobi", 4));
        dupleWinners.add(new Car("crong", 6));
        dupleWinners.add(new Car("honux", 6));
    }

    @DisplayName("split 테스트")
    @Test
    void 문자열_split_테스트() {
        assertThat(IoMain.splitNames("pobi,crong,honux")).hasSize(3);
    }

    @DisplayName("우승자 테스트")
    @Test
    void 우승자_테스트() {
        assertThat(IoMain.winnersString(cars)).isEqualTo("honux");
        assertThat(IoMain.winnersString(dupleWinners)).isEqualTo("crong, honux");
    }
}
