package racing.domain.score;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.Car;
import racing.domain.car.Cars;

class HistoryTest {

    @Test
    @DisplayName("생성 테스트")
    void history_ctor_test() {
        assertThatNoException().isThrownBy(() -> new History(new ArrayList<>()));
    }

    @Test
    @DisplayName("이력 저장 테스트")
    void history_add_test() {
        //given
        History history = new History(new ArrayList<>());

        //when
        History mang = history.save(new Cars(List.of(new Car("mang"))));

        //then
        assertThat(mang).isEqualTo(new History(new ArrayList<>(List.of(new Cars(List.of(new Car("mang")))))));
    }
}