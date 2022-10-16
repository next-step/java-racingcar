package step4;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingResultTest {

    @Test
    void 결과값에_입력받은_자동차_리스트는_같은이름과_같은거리를_가진다() {
        List<Car> racingCars = new ArrayList<>();
        racingCars.add(new Car("a", 1));
        racingCars.add(new Car("b", 2));
        racingCars.add(new Car("c", 3));
        racingCars.add(new Car("d", 4));
        racingCars.add(new Car("e", 5));

        RacingResult racingResult = new RacingResult(racingCars);
        assertThat(racingResult.getResults().size()).isEqualTo(racingCars.size());
        assertThat(racingResult.getResults()).extracting("name").contains("a", "b", "c", "d", "e");
        assertThat(racingResult.getResults()).extracting("distance").contains(1, 2, 3, 4, 5);
    }
}
