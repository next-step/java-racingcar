package step4.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.ipnut.InputNames;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("Cars 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        InputNames inputNames = new InputNames("a,b,c");

        // when
        Cars cars = new Cars(inputNames);

        // then
        assertThat(cars).isNotNull();

    }
}