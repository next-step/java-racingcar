package step4.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.ipnut.InputNames;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("Cars 인스턴스 부적절한 값 주입시 예외처리 발생 여부 테스트")
    @Test
    void 검증() {

        // given
        InputNames inputNames = null;

        // when
        assertThatThrownBy(()-> {
            new Cars(inputNames);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 값을 사용했습니다.");

    }

}