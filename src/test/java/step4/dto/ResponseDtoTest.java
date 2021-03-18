package step4.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.domain.racing.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
}