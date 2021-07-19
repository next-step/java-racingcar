package type;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class MessageFactoryTest {
    @Test
    void 생성자_테스트() throws Exception {
        // given
        Class<MessageFactory> expected = MessageFactory.class;

        // when
        MessageFactory actual = new MessageFactory();

        // then
        Assertions.assertThat(actual).isNotNull().isInstanceOf(expected);
    }

    @Test
    void 입력_에러_메시지() {
        // given
        String expected = "입력값이 올바르지 않습니다.";

        // when
        String actual = MessageFactory.getInputErrorMessage();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
