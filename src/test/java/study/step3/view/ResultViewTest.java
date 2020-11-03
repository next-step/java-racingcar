package study.step3.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import study.step3.domain.Car;
import study.step3.domain.RaceRecord;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static study.step3.view.ResultView.nameWithSpace;

class TestingResultView extends ResultView {
    private final StringBuilder stringBuilder;

    public TestingResultView(StringBuilder stringBuilder, RaceRecord raceRecord, Set<String> winners) {
        super(raceRecord, winners);
        this.stringBuilder = stringBuilder;
    }

    @Override
    protected void print(String content) {
        stringBuilder.append(content);
    }
}

public class ResultViewTest {

    private StringBuilder stringBuilder;
    private ResultView resultView;
    private final RaceRecord raceRecord = new RaceRecord();
    private final Set<String> winners = new HashSet<>();

    @BeforeEach
    void setUp() {
        stringBuilder = new StringBuilder();
        resultView = new TestingResultView(stringBuilder, raceRecord, winners);
    }

    @ParameterizedTest
    @ArgumentsSource(OneCarRacingRecordArgumentProvider.class)
    @DisplayName("'ResultView'는 한대의 차가 움직인 결과를 출력할 수 있다.")
    void reportResultOneCarMove(String name, Boolean[] moves, String expected) {
        addRecord(name, moves);

        resultView.printRaceHistory();

        assertThat(stringBuilder.toString()) //
                .isEqualTo(expected);
    }

    @Test
    @DisplayName("'ResultView'는 두대의 차가 두번 움직인 결과를 출력할 수 있다.")
    void reportResultTwoCarTwoMove() {

        addRecord("blue", new Boolean[]{false, true});
        addRecord("red", new Boolean[]{true, true});

        resultView.printRaceHistory();

        //@formatter:off
        assertThat(stringBuilder.toString())
                .isEqualTo(
                    lineEmpty() +
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

        addRecord("blue", new Boolean[]{false, true, true});
        addRecord("red", new Boolean[]{true, true, true});

        resultView.printRaceHistory();

        //@formatter:off
        assertThat(stringBuilder.toString())
                .isEqualTo(
                        lineEmpty() +
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

    @Test
    @DisplayName("우승자를 출력한다")
    void reportWinners() {

        addWinners("blue", "red");
        resultView.printWinners();

        assertThat(stringBuilder.toString()) //
                .isEqualTo("우승자는 'blue', 'red' 입니다.");
    }

    private void addWinners(String... winners) {
        this.winners.addAll(Arrays.asList(winners));
    }

    private void addRecord(String name, Boolean[] moves) {
        for (Boolean move : moves) {
            raceRecord.saveRecord(makeCar(name, move));
        }
    }

    private Car makeCar(String name, Boolean move) {
        return new Car() {
            @Override
            public boolean isMoved() {
                return move;
            }

            @Override
            public void move() {

            }

            @Override
            public String getName() {
                return name;
            }
        };
    }

    static class OneCarRacingRecordArgumentProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            //@formatter:off
            return Stream.of(
                    Arguments.of("blue", new Boolean[]{true}, // 한번 시도에서 한번 움직인 결과
                                    lineEmpty() +
                                    line(nameWithSpace("blue") + ": -")
                    ),

                    Arguments.of("blue", new Boolean[]{false}, // 한번 시도에서 0번 움직인 결과
                                    lineEmpty() +
                                    line(nameWithSpace("blue") + ": ")
                    ),

                    Arguments.of("blue", new Boolean[]{true, false}, // 두번 시도에서 한번 움직인 결과
                                    lineEmpty() +
                                    line(nameWithSpace("blue") + ": -") +
                                    lineEmpty() +
                                    line(nameWithSpace("blue") + ": -")
                    ),

                    Arguments.of("blue", new Boolean[]{true, true}, // 두번 시도에서 두번 움직인 결과
                                    lineEmpty() +
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
