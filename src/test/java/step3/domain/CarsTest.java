package step3.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    void 자동차_그룹을_생성한다() {
        //given
        List<Car> carList = new ArrayList<>();
        for (int count = 0; count < 3; count++) {
            carList.add(Car.create());
        }
        //when
        Cars cars = Cars.join(carList);
        //then
        assertThat(cars).isNotNull();
        assertThat(cars).isInstanceOf(Cars.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 경주에_참여할_자동차_수가_null_혹은_empty_면_IllegalArgumentException이_발생한다(List<Car> carList) {
        //given
        //when & then
        assertThatThrownBy(() -> Cars.join(carList))
                .isInstanceOf(IllegalArgumentException.class);
    }
}