package calculator.factory;

import calculator.factory.splitter.CustomSeparatorSplitter;
import calculator.factory.splitter.DefaultSplitter;
import calculator.factory.splitter.Splitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SplitterFactoryTest {

    @Test
    @DisplayName("getSplitter 파라미터로 true 일 경우 CustomSeparatorSplitter.class 를 반환하고, false 의 경우 DefaultSplitter.class를 반환한다.")
    void factoryTest() throws Exception {
        SplitterFactory factory = new SplitterFactory();

        Splitter splitter = factory.getSplitter(true);
        assertThat(splitter).isInstanceOf(CustomSeparatorSplitter.class);

        Splitter splitter2 = factory.getSplitter(false);
        assertThat(splitter2).isInstanceOf(DefaultSplitter.class);
    }

}