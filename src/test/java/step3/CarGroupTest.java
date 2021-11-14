package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarGroupTest {

    @Test
    void 자동차그룹_쉼표_생성() {
        assertThat(new CarGroup("nell,dklee,good")).isEqualTo(new CarGroup("nell,dklee,good"));
    }
    @Test
    void 자동차그룹_앞뒤_공백포함_쉼표_생성() {
        assertThat(new CarGroup("nell,dklee")).isEqualTo(new CarGroup("nell,dklee  "));
        assertThat(new CarGroup("nell, dklee")).isEqualTo(new CarGroup("nell,dklee "));
    }
}
