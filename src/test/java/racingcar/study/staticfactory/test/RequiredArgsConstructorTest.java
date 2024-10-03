package racingcar.study.staticfactory.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.study.staticfactory.example.BlogUser;

public class RequiredArgsConstructorTest {
    @Test
    void staticName() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            BlogUser johnGrib = BlogUser.of(1L, "JohnGrib");
        });
    }
}
