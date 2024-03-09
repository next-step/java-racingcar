package view;

import model.RacingRecord;
import model.Record;

import java.util.List;

public class ResultView {

    private static final String HYPHEN = "-";
    private static final String NEW_LINE = System.lineSeparator();
    private StringBuilder sb;

    public ResultView() {
        this.sb = new StringBuilder();

        this.sb.append("실행결과");
        appendNewLine();
    }

    public void draw(int turn, RacingRecord racingRecord) {
        for (int t = 1; t <= turn; t++) {
            hyphenate(racingRecord.racingRecord(t));
            appendNewLine();
        }
    }

    public void hyphenate(List<Record> records) {
        for (Record record : records) {
            sb.append(String.format("%s : %s", record.getName(), HYPHEN.repeat(record.getPosition())));
            appendNewLine();
        }
    }

    public void appendNewLine() {
        sb.append(NEW_LINE);
    }

    public void appendWinners(List<String> winners) {
        sb.append(String.join(", ", winners)).append("가 최종 우승 했습니다");
    }
    
    public void print() {
        System.out.println(sb.toString());
    }


}
