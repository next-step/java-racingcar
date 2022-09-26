package racing.domain.car;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.exception.UnderOfZeroException;
import racing.domain.generator.NumberGenerator;
import racing.domain.score.History;

class LabsTest {

    NumberGenerator advanced = () -> 4;

    @Test
    @DisplayName("생성 테스트")
    void labs_ctor_test() {
        assertThatNoException().isThrownBy(() -> new Labs(1));
    }

    @Test
    @DisplayName("음수를 입력하면 예외가 발생한다")
    void input_negative_throw_exception_test() {
        assertThatThrownBy(() -> new Labs(-1))
            .isInstanceOf(UnderOfZeroException.class)
            .hasMessage("0 미만은 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("입력한 숫자만큼 자동차경주를 진행한다")
    void input_number_racing_test() {
        //given
        Labs labs = new Labs(1);
        Cars cars = new Cars(List.of(new Car("mang")), advanced);

        //when
        Track racedTrack = labs.racing(new History(List.of(cars)), cars);

        //then
        Cars equalsCars = new Cars(List.of(new Car(1, "mang")), advanced);
        Track track = new Track(new History(List.of(cars, equalsCars)), equalsCars);
        Assertions.assertThat(racedTrack).isEqualTo(track);


    }

}