package carracing.domain.record;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundRecordTest {

    @DisplayName("3대의 자동차 목록에서 3라운드동안 가장 멀리 이동한 자동차 1대를 찾을 수 있다.")
    @Test
    void getOneWinner() {
        // given
        CarRecord green = CarRecord.of("green", 3);
        CarRecord blue = CarRecord.of("blue", 4);
        CarRecord red = CarRecord.of("red", 5);
        RoundRecord roundRecord = RoundRecord.from(List.of(green, blue, red));

        // when
        List<String> result = roundRecord.getLeadingCarNames();

        // then
        assertThat(result).hasSize(1)
                .containsExactly("red");
    }

    @DisplayName("3대의 자동차 목록에서 3라운드동안 가장 멀리 이동한 자동차 2대를 찾을 수 있다.")
    @Test
    void getTwoWinners() {
        // given
        CarRecord green = CarRecord.of("green", 3);
        CarRecord blue = CarRecord.of("blue", 4);
        CarRecord red = CarRecord.of("red", 4);
        RoundRecord roundRecord = RoundRecord.from(List.of(green, blue, red));

        // when
        List<String> result = roundRecord.getLeadingCarNames();

        // then
        assertThat(result).hasSize(2)
                .containsExactlyInAnyOrder("blue", "red");
    }

    @DisplayName("3대의 자동차 목록에서 3라운드동안 가장 멀리 이동한 자동차 3대를 찾을 수 있다.")
    @Test
    void getThreeWinners() {
        // given
        CarRecord green = CarRecord.of("green", 4);
        CarRecord blue = CarRecord.of("blue", 4);
        CarRecord red = CarRecord.of("red", 4);
        RoundRecord roundRecord = RoundRecord.from(List.of(green, blue, red));

        // when
        List<String> result = roundRecord.getLeadingCarNames();

        // then
        assertThat(result).hasSize(3)
                .containsExactlyInAnyOrder("green", "blue", "red");
    }

}