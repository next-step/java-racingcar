package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    void 입력_받은_이름으로_Car_객체를_만든다() {
        String[] strings = new String[]{"jack", "smith", "lana"};
        Cars cars = new Cars(strings);
        List<Car> getCars = cars.getCars();

        assertThat(getCars.get(0).getName()).isEqualTo("jack");
        assertThat(getCars.get(1).getName()).isEqualTo("smith");
        assertThat(getCars.get(2).getName()).isEqualTo("lana");
    }
}
