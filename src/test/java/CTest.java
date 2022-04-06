import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CTest {
    //클래스명이 무엇인지 메서드명이 무엇인지 중요하지 않다. -> 나중에 설계 영역으로 넘어가도 좋다.
    //input과 output을 잘 정하는 것이 중요하다.
    //프로덕션코드(실제 동작하는 로직)가 아직 구현되지 않았기 때문에 처음에는 무조건 컴파일 에러가 난다.
    //프로덕션코드를 만들어준다.
    @Test
    void name() {
        int result = C.c(null);
        assertThat(result).isEqualTo(0);
    }
}
