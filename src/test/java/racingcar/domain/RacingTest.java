package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.Record;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @DisplayName("주어진 car 이름 수 만큼 Car객체를 생성하여 Racing 도메인 객체를 만든다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,crong", "pobi,crong,honux"})
    void create(String value) {
        List<String> carNames = List.of(value.split(","));
        Racing racing = Racing.create(carNames);

        assertThat(racing).isNotNull();
        assertThat(racing.getCars()).hasSize(carNames.size());
    }

    @DisplayName("Racing을 시작하면 차들의 record를 return 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "pobi,crong", "pobi,crong,honux"})
    void start(String value) {
        List<String> carNames = List.of(value.split(","));
        Racing racing = Racing.create(carNames);

        // when
        List<Record> records = racing.start();

        // then
        assertThat(records).hasSize(carNames.size());
        for (int i = 0; i < carNames.size(); i++) {
            assertThat(records.get(i).getCarName()).isEqualTo(carNames.get(i));
            assertThat(records.get(i).getMoveCount()).isGreaterThanOrEqualTo(0);
        }
    }
}
