package mvc.domain.car;

import mvc.domain.dto.CarState;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void Cars_생성_테스팅() {
        //given
        String[] names = new String[]{"pobi", "eeseul", "teacher"};

        Cars cars = Cars.createAllCars(names);

        List<String> nameList = Arrays.asList(names);

        //when
        boolean expected = true;

        List<CarState> states = cars.getStates();

        for (CarState state : states) {
            expected &= nameList.contains(state.getName());
        }

        //then
        assertThat(expected).isTrue();
    }
}