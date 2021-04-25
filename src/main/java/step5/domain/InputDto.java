package step5.domain;

import java.util.List;

public class InputDto {

    private List<String> nameList;
    private int trial;

    public InputDto(List<String> nameList, int trial) {
        this.nameList = nameList;
        this.trial = trial;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public int getTrial() {
        return trial;
    }
}
