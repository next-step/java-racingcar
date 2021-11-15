package study04;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class EngineTest {

    @Test
    @DisplayName("테스트01 - 기본 엔진 생성 테스트")
    void test01() {
        Engine engine = Engine.createEngine();
        assertThat(engine.isLastedRun()).isFalse();
    }

    @Test
    @DisplayName("테스트02 - 무조건 달리는/달리지 않는 엔진 테스트")
    void test02() {
        Engine hyperEngine = Engine.createEngine(10, 0);
        Engine brokenEngine = Engine.createEngine(10, 10);

        IntStream.range(0, 10).forEach(i -> {
            assertThat(hyperEngine.isRun()).isTrue();
            assertThat(brokenEngine.isRun()).isFalse();
        });
    }

    @Test
    @DisplayName("테스트03 - 엔진 구동 테스트")
    void test03() {
        Engine engine = Engine.createEngine();

        IntStream.range(0, 100).forEach(i -> {
            boolean run = engine.isRun();
            if (run) {
                assertThat(engine.isLastedRun()).isTrue();
            } else {
                assertThat(engine.isLastedRun()).isFalse();
            }
        });
    }
}
