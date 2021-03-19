package step4.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.racing.Cars;

import static org.assertj.core.api.Assertions.assertThat;

class ResponseDtoTest {

    @DisplayName("ResponseDto 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        Cars cars = new Cars("a,b,c");

        // when
        ResponseDto responseDto = new ResponseDto(cars);

        // then
        assertThat(responseDto).isNotNull();
    }

    @DisplayName("ResponseDto 인스턴스가 포함한 값 반환 여부 테스트")
    @Test
    void 반환() {
        // given
        Cars expected = new Cars("a,b,c");

        // when
        ResponseDto responseDto = new ResponseDto(expected);
        Cars actual = responseDto.cars();

        // then
        assertThat(actual).isEqualTo(expected);
    }
}