package mvc.domain.car;

import mvc.domain.dto.CarState;
import mvc.domain.dto.StateOfCars;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void Cars_생성_테스팅() {
        //given
        String[] names = new String[]{"pobi", "eeseul", "teacher"};

        Cars cars = Cars.createAllCars(names);
        StateOfCars states = cars.getStates();

        //when
        List<String> actualName = states.getStates()
                .stream()
                .map(CarState::getName)
                .collect(Collectors.toList());

        //then
        assertThat(actualName).contains(names);
        assertThat(actualName).hasSize(names.length);
    }
}