package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameTest {

    @DisplayName("이름 5자를 초과할 경우 에러를 반환")
    @Test
    void 이름_5자_이상_사용시_에러() {
        String name = "우아한형제들";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name(name);
        }).withMessage("이름은 5자를 초과할 수 없습니다.");
    }

    @DisplayName("이름 5자를 초과하지 않을 경우 정상적으로 생성")
    @Test
    void 이름_5자_이하일경우_성공() {
        String nameText = "배달의민족";

        Name name = new Name(nameText);

        assertThat(name).isEqualTo(new Name(nameText));
    }


}