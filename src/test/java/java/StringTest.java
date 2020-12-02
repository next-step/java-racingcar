package java;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    public void splitContain() {
        // given
        String foo = "1,2";

        // when
        String[] splitFoo = foo.split(",");

        // then
        assertThat(splitFoo).contains("1", "2");
    }
}
