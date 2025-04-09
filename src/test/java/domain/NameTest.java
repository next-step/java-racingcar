package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NameTest {
    @Test
    @DisplayName("이름이 같은 경우 같은 객체 간주됨")
    public void nameTest() {
        Name name = new Name("pobi");
        Name name2 = new Name("pobi");
        Name name3 = new Name("brown");
        Assertions.assertAll(
            () -> assertThat(name).isEqualTo(name2),
            () -> assertThat(name).isNotEqualTo(name3)
        );
    }
}
