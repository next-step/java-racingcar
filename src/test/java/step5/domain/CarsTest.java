package step5.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차 이름을 부여하면 유저를 해당 이름으로 생성해준다.")
    @Test
    void checkUserCarname() {
        List<Car> compareCars = Stream.of(new Car("pobi", ""), new Car("crong", ""), new Car("honux", ""))
                                      .collect(
                                              Collectors.toList());

        Cars carAssembler = new Cars(new String[] { "pobi", "crong", "honux" });
        List<Car> cars = carAssembler.getCars();

        assertAll(() -> assertThat(cars).hasSameSizeAs(compareCars),
                  () -> assertThat(cars.get(0).getName()).isEqualTo(compareCars.get(0).getName()),
                  () -> assertThat(cars.get(1).getName()).isEqualTo(compareCars.get(1).getName()),
                  () -> assertThat(cars.get(2).getName()).isEqualTo(compareCars.get(2).getName())
        );

    }
}
