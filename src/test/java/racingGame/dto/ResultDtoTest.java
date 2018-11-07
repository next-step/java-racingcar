package racingGame.dto;

import org.junit.Test;
import racingGame.domain.Car;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultDtoTest {

    @Test
    public void 레이싱_결과의_dash_를_HTML_공백문자로_정상_변환한다() {
        Car car = new Car("dicorndl", 1);

        ResultDto dto = new ResultDto(Collections.singletonList(car));

        assertThat(dto.getRacingResults())
            .hasSize(1)
            .containsExactly("dicorndl : &nbsp;");
    }

    @Test
    public void 우승자_이름을_정상_반환한다() {
        Car winner1 = new Car("winner1", 3);
        Car winner2 = new Car("winner2", 3);
        Car other = new Car("other", 2);

        ResultDto dto = new ResultDto(Arrays.asList(winner1, winner2, other));
        assertThat(dto.getWinnerNames()).isEqualTo("winner1, winner2");
    }
}