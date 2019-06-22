package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    void 이름을_생성한다() {
        String testName = "tester";
        Name name = new Name(testName);

        assertThat(name).isNotNull();
    }
}
