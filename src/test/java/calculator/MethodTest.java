package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Java 메소드를 테스트하기 위한 테스트코드
 * */
public class MethodTest {
    @Test
    void splitMethod(){
        assertThat("1,2:3".split("[,:]")).hasSize(3);
    }
}
