package racingcar.view.input;

import java.util.List;

public class MockCommandLineReader extends CommandLineReader {

    private Integer num;
    private List<String> csv;

    MockCommandLineReader(Integer num, List<String> csv) {
        this.num = num;
        this.csv = csv;
    }

    @Override
    public Integer getNumber() {
        return num;
    }

    @Override
    public List<String> getCsv() {
        return csv;
    }
}
