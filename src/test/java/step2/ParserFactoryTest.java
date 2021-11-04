package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParserFactoryTest {

    @Test
    void getIntegerParser() throws Exception {
        Parser<Integer> parser = ParserFactory.getParser(Integer.class);
        assertThat(parser.getClass().isAssignableFrom(IntegerParser.class)).isTrue();
    }

    @Test
    void getOperatorParser() throws Exception {
        Parser<Operator> parser = ParserFactory.getParser(Operator.class);
        assertThat(parser.getClass().isAssignableFrom(OperatorParser.class)).isTrue();
    }

    @Test
    void getUnsupportedType_thrownIllegalArgumentException() throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ParserFactory.getParser(String.class))
                .withMessageContaining("지원하지 않는 타입");
    }

}
