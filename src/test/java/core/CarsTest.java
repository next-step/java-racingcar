package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    @DisplayName("carName 이 carNames 로 구성된 Car 들이 만들어져야 한다")
    void fromCarNames() {
        //given
        List<String> carNames = new ArrayList<>(Arrays.asList("abc", "bcd", "cde"));

        //when
        Cars result = Cars.fromCarNames(carNames);

        //then
        assertThat(carNames.size()).isEqualTo(result.getCars().size());
        result.getCars().forEach(car -> carNames.remove(car.getCarName()));
        assertThat(carNames.size()).isEqualTo(0);
    }
}