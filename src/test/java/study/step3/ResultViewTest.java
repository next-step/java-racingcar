package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static study.step3.ResultView.nameWithSpace;

class TestingResultView extends ResultView {
    private final StringBuilder stringBuilder;

    public TestingResultView(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    protected void print(String content) {
        stringBuilder.append(content);
    }
}

public class ResultViewTest {

    public static final int NAME = 0;
    public static final int IS_MOVED = 1;
    private StringBuilder stringBuilder;
    private ResultView resultView;

    @BeforeEach
    void setUp() {
        stringBuilder = new StringBuilder();
        resultView = new TestingResultView(stringBuilder);
    }

    @ParameterizedTest
    @ArgumentsSource(OneCarRacingRecordArgumentProvider.class)
    @DisplayName("'ResultView'는 한대의 차가 움직인 결과를 출력할 수 있다.")
    void reportResultOneCarMove(String name, int moves, String expected) {
        addRecord(name, moves);

        resultView.report();

        assertThat(stringBuilder.toString()) //
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("'ResultView'는 두대의 차가 두번 움직인 결과를 출력할 수 있다.")
    void reportResultTwoCarTwoMove() {

        addResult(new LapResult("blue", false), new LapResult("red", true));
        addResult(new LapResult("blue", true), new LapResult("red", true));

        resultView.report();

        //@formatter:off
        assertThat(stringBuilder.toString())
                .isEqualTo(
                    line("실행결과") +
                    line(nameWithSpace("blue") + ": ") +
                    line(nameWithSpace("red") + ": -") +
                    lineEmpty() +
                    line(nameWithSpace("blue") + ": -") +
                    line(nameWithSpace("red") + ": --")
                );
        //@formatter:on
    }

    @Test
    @DisplayName("'ResultView'는 두대의 차가 세번 움직인 결과를 출력할 수 있다.")
    void reportResultTwoCarThreeMove() {

        addResult(new LapResult("blue", false), new LapResult("red", true));
        addResult(new LapResult("blue", true), new LapResult("red", true));
        addResult(new LapResult("blue", true), new LapResult("red", true));

        resultView.report();

        //@formatter:off
        assertThat(stringBuilder.toString())
                .isEqualTo(
                        line("실행결과") +
                                line(nameWithSpace("blue") + ": ") +
                                line(nameWithSpace("red") + ": -") +
                                lineEmpty() +
                                line(nameWithSpace("blue") + ": -") +
                                line(nameWithSpace("red") + ": --") +
                                lineEmpty() +
                                line(nameWithSpace("blue") + ": --") +
                                line(nameWithSpace("red") + ": ---")
                );
        //@formatter:on
    }

    private void addResult(LapResult aCar, LapResult bCar) {
        Set<LapResult> firstLap = new HashSet<>();
        firstLap.add(aCar);
        firstLap.add(bCar);
        resultView.add(firstLap);
    }

    static class OneCarRacingRecordArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            //@formatter:off
            return Stream.of(
                    Arguments.of(new String[]{"blue:true"}, // 한대의 차가 한번 움직인 결과
                                    line("실행결과") +
                                    line(nameWithSpace("blue") + ": -")
                    ),

                    Arguments.of(new String[]{"blue:false"},
                                    line("실행결과") +
                                    line(nameWithSpace("blue") + ": ")
                    ),

                    Arguments.of(new String[]{"blue:true", "blue:false"},
                                    line("실행결과") +
                                    line(nameWithSpace("blue") + ": -") +
                                    lineEmpty() +
                                    line(nameWithSpace("blue") + ": -")
                    ),

                    Arguments.of(new String[]{"blue:true", "blue:true"},
                                    line("실행결과") +
                                    line(nameWithSpace("blue") + ": -") +
                                    lineEmpty() +
                                    line(nameWithSpace("blue") + ": --")
                    )
            );
            //@formatter:on
        }

    }

    private static String lineEmpty() {
        return line("");
    }

    private static String line(String content) {
        return content + System.lineSeparator();
    }
}
