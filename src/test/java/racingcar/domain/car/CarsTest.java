package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.InvalidCarSettingException;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("자동차 3대 생성 성공 테스트")
    void 자동차_3대_생성_성공_테스트() {
        Cars cars = new Cars(Arrays.asList("pobi", "bass", "hj"));
        assertThat(cars.getCars().size()).isEqualTo(3);
    }
    
    @Test
    @DisplayName("자동차 1대 입력 테스트")
    void 자동차_1대_입력_실패_테스트() {
        assertThatThrownBy(() -> new Cars(Arrays.asList("hjjang")))
                .isInstanceOf(InvalidCarSettingException.class)
                .hasMessage("2개 이상의 자동차를 입력해야 시작 가능합니다.");
    }
}
