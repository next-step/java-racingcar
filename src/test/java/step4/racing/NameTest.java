package step4.racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.racing.Name;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    @DisplayName("이름 생성 성공 테스트")
    public void name_test() throws Exception {
        // given
        String sut = "홍길동";
        // when
        Name name = Name.defaultOf(sut);
        // then
        assertThat(name).extracting("name").isEqualTo(sut);
    }

    @Test
    @DisplayName("이름 생성 테스트 -> 단, 이름은 5자를 넘을 수 없다.")
    public void name_length_limit_under_5() {
        // given
        String sut = "홍길동";
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> Name.defaultOf("5자가넘어"));
    }
}
