package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.exception.OutBoundCarListSizeException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @Test
    @DisplayName("자동차가 1개 미만일 경우 익셉션 확인")
    void validCarCount() {
        //given
        List<Car> carList = Collections.emptyList();
        //then
        assertThatThrownBy(() -> new Cars(carList)).isInstanceOf(OutBoundCarListSizeException.class);
    }

}