package race.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarFactoryTest {
    @Test
    void 자동차_리스트_생성() {
        List<Car> carList = CarFactory.createCars("pobi,nana,kai");
        assertThat(carList).hasSize(3);
    }

    @Test
    void split() {
        List<String> value = CarFactory.splitName("pobi,nana,kai");
        assertThat(value).contains("pobi");
        assertThat(value).containsExactly("pobi","nana","kai");
    }

}
