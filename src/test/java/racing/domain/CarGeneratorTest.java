package racing.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarGeneratorTest {

    @Test
    void 문자열과_이동전략을_주입받아_차를_생성한다() {
        String input = "a,b,c,d";
        List<Car> cars = CarGenerator.createCars("a,b,c,d", new RandomMoveRule());

        String[] names = input.split(",");
        for(int i = 0; i < cars.size(); i++) {
            assertThat(cars.get(i).getName()).isEqualTo(names[i]);
            assertThat(cars.get(i).getDistance()).isEqualTo(0);
        }
    }
}
