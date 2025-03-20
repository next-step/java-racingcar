import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameSettingsTest {

    @Test
    @DisplayName("자동차 이름 목록이 비어있으면 에러가 발생한다")
    void emptyCarNamesListThrowsError() {
        assertThatThrownBy(() -> new GameSettings(new String[0], 3)).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름 목록이 비어있습니다.");

        assertThatThrownBy(() -> new GameSettings(null, 3)).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름 목록이 비어있습니다.");
    }

    @Test
    @DisplayName("자동차 이름이 비어있으면 에러가 발생한다")
    void emptyCarNameThrowsError() {
        String[] carNamesWithBlank = {"car1", "", "car3"};
        assertThatThrownBy(() -> new GameSettings(carNamesWithBlank, 3)).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 비어있을 수 없습니다.");

        String[] carNamesWithNull = {"car1", null, "car3"};
        assertThatThrownBy(() -> new GameSettings(carNamesWithNull, 3)).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 비어있을 수 없습니다.");
    }

    @Test
    @DisplayName("시도 횟수가 1 미만이면 에러가 발생한다")
    void roundCountLessThanOneThrowsError() {
        String[] carNames = {"car1", "car2", "car3"};
        assertThatThrownBy(() -> new GameSettings(carNames, 0)).isInstanceOf(IllegalArgumentException.class).hasMessage("시도 횟수는 1 이상이어야 합니다.");

        assertThatThrownBy(() -> new GameSettings(carNames, -1)).isInstanceOf(IllegalArgumentException.class).hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("유효한 입력으로 GameSettings가 생성된다")
    void validInputCreatesGameSettings() {
        String[] carNames = {"car1", "car2", "car3"};
        GameSettings settings = new GameSettings(carNames, 3);

        assertThat(settings.getCarNames()).isEqualTo(carNames);
        assertThat(settings.getCarCount()).isEqualTo(3);
        assertThat(settings.getRoundCount()).isEqualTo(3);
    }
} 