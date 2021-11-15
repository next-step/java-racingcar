package racingcar.domain.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.model.Cars;

public class ResultDtoTest {

    @ParameterizedTest
    @ValueSource(strings = "kim,dong,hyo")
    @DisplayName("ResultDto 생성 확인")
    void createResultDto(String name) {
        assertThat(ResultDto.from(Cars.from(name))).isEqualTo(ResultDto.from(Cars.from(name)));
    }

}
