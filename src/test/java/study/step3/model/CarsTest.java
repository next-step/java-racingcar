package study.step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("자동차 수에 따른 동일한 리스트 개수 조회")
    @ParameterizedTest(name="{displayName} | 시도 점수: {0}")
    @ValueSource(ints = {1, 2, 3})
    void 자동차_수에_따른_동일한_리스트_조회(int carCount) {
        Cars cars = new Cars(carCount);

        assertThat(cars.getCars().size()).isEqualTo(carCount);
    }
}