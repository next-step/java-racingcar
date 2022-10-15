package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("이름이 빈값이고, 1자이하일떄, 에러를 반환합니다.")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    void 이름이_1자이하일떄_에러를_반환(String name) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Name(name);
        }).withMessage("1자 이상의 이름을 입력해주세요.");
    }

}