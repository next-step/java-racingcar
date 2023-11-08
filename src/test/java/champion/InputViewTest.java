package champion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {

    private List<Car> cars = new ArrayList<Car>();

    @BeforeEach
    void setCars() {
        cars.add(new Car("pobi", 3));
        cars.add(new Car("crong", 5));
        cars.add(new Car("honux", 6));
    }

    @DisplayName("split 테스트")
    @Test
    void 문자열_split_테스트() {
        assertThat(InputView.splitNames("pobi,crong,honux")).hasSize(3);
    }

    @DisplayName("우승자 테스트")
    @Test
    void 우승자_테스트() {
        assertThat(InputView.getChampionString(cars)).isEqualTo("honux");
    }
}
