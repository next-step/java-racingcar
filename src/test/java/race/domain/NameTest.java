package race.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @Test
    void name_생성() {
        Name name = new Name("pobi");
        assertThat(name).isEqualTo(new Name("pobi"));
    }

    @Test
    void name_null_값() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name(""))
                .withMessageMatching("자동차 이름이 비어있습니다.");
    }

    @Test
    void name_길이() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Name("abcdef"))
                .withMessageMatching("자동차 이름의 길이는 5 이하여야 합니다.");
    }
}
