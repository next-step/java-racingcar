package racingcar.view;

import racingcar.dto.RecordDto;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class ResultView {
    private final String SYMBOL = "-";
    private final PrintWriter output;

    public ResultView(PrintWriter output) {
        this.output = output;
    }

    public void showResultHeader() {
        output.println("실행 결과");
    }

    public void showAtStep(List<RecordDto> recordAtStep) {
        recordAtStep.stream()
                .map(recordDto -> format(
                        "%s : %s",
                        recordDto.getName(),
                        getRepeatedSymbol(recordDto.getPosition())))
                .forEach(output::println);
        output.println();
    }

    private String getRepeatedSymbol(Integer repeatCount) {
        return String.join("", Collections.nCopies(repeatCount, SYMBOL));
    }

    public void showWinner(List<RecordDto> winnerRecord) {
        output.print(format("%s가 최종 우승했습니다.", winnerRecord.stream().map(RecordDto::getName).collect(Collectors.joining(", "))));
    }
}
