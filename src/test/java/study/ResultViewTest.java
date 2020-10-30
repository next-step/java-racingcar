package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    public static final int ID = 0;
    public static final int IS_MOVED = 1;

    @ParameterizedTest
    @ArgumentsSource(OneCarRacingRecordArgumentProvider.class)
    @DisplayName("'ResultView'는 한대의 차가 움직인 결과를 출력할 수 있다.")
    void reportResultOneCarMove(String[] records, String expected) {

        ResultView resultView = new ResultView();

        for (String lapRecord : records) {
            String[] split = lapRecord.split(":");
            Set<LapResult> lap = new HashSet<>();
            lap.add(new LapResult(Long.parseLong(split[ID]), Boolean.valueOf(split[IS_MOVED])));
            resultView.add(lap);
        }

        resultView.report();

        assertThat(resultView.getReportContent()) //
                .isEqualTo(expected);
    }

    static class OneCarRacingRecordArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            //@formatter:off
            return Stream.of(
                    Arguments.of(new String[]{"0:true"}, // 한대의 차가 한번 움직인 결과
                            line("실행결과") +
                                    line("-")
                    ),

                    Arguments.of(new String[]{"0:false"},
                            line("실행결과") +
                                    line("")
                    ),

                    Arguments.of(new String[]{"0:true", "0:false"},
                            line("실행결과") +
                                    line("-") +
                                    lineEmpty() +
                                    line("-")
                    ),

                    Arguments.of(new String[]{"0:true", "0:true"},
                            line("실행결과") +
                                    line("-") +
                                    lineEmpty() +
                                    line("--")
                    )
            );
            //@formatter:on
        }

        private String lineEmpty() {
            return line("");
        }

        private String line(String content) {
            return content + "\n";
        }
    }
}
