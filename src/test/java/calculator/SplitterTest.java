package calculator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @Test
    public void defaultSplit() {
        String text = "1,2,3";
        DefaultSplitter splitter = new DefaultSplitter();
        assertThat(splitter.isSupports(text)).isTrue();
        assertThat(splitter.split(text)).containsSequence("1", "2", "3");
    }

    @Test
    public void customSplit() {
        String text = "//;\n1;2;3";
        CustomSplitter splitter = new CustomSplitter();
        assertThat(splitter.isSupports(text)).isTrue();
        assertThat(splitter.split(text)).containsSequence("1", "2", "3");
    }

    @Test
    public void splitters() {
        String text = "1,2,3";
        Splitter splitter = createSplitters().stream()
                .filter(s -> s.isSupports(text))
                .findFirst().get();

        assertThat(splitter.split(text)).containsSequence("1", "2", "3");
    }

    private List<Splitter> createSplitters() {
        return Arrays.asList(
                    new DefaultSplitter(), new CustomSplitter());
    }
}