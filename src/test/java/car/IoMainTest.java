package car;

import car.domain.Car;
import car.views.IoMain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IoMainTest {

    private List<Car> oneWinners = new ArrayList<Car>();


    @BeforeEach
    void setCars() {
        oneWinners.add(new Car("pobi", 3));
        oneWinners.add(new Car("crong", 5));
        oneWinners.add(new Car("honux", 6));
    }

    @DisplayName("split 테스트")
    @Test
    void 문자열_split_테스트() {
        assertThat(IoMain.splitNames("pobi,crong,honux")).hasSize(3);
    }

    @DisplayName("우승자 문자열 테스트")
    @Test
    void 우승자_테스트() {
        assertThat(IoMain.winnersString(oneWinners)).isEqualTo("honux");
    }
}
