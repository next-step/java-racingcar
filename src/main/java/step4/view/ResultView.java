package step4.view;

import step4.dto.RecordDto;

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

    public void show(List<List<RecordDto>> records) {
        output.println("실행 결과");
        records.forEach(this::showAtStep);
    }

    private void showAtStep(List<RecordDto> recordAtStep) {
        recordAtStep.forEach(recordDto -> output.println(format("%s : %s", recordDto.getName(), String.join("", Collections.nCopies(recordDto.getRecord(), SYMBOL)))));
        output.println();
    }

    public void showWinner(List<RecordDto> winnerRecord) {
        output.print(format("%s가 최종 우승했습니다.", winnerRecord.stream().map(RecordDto::getName).collect(Collectors.joining(", "))));
    }
}
