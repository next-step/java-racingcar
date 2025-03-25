import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    @Test
    @DisplayName("단체 생성 테스트")
    public void groupTest() {
        List<Car> carList = List.of(
            new Car("pobi"),
            new Car("honux"),
            new Car("brown")
        );
        Cars cars = new Cars(carList);
        assertThat(carList.size()).isEqualTo(3);
    }
}
