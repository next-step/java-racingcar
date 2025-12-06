package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    void 자동차_이름이_5자_이하면_CarName이_생성된다() {
        String name = "넥스트스텝";
        CarName carName = new CarName(name);

        assertThat(carName.getCarName()).isEqualTo(name);
    }

    @Test
    void 자동차_이름이_5자_초과시_예외가_발생한다() {
        assertThatThrownBy(() -> new CarName("넥스트스텝입니다"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
