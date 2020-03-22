package step3;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private List<Round> roundInfoList = new ArrayList<Round>();

    public List<Round> getRoundInfoList() {
        return this.roundInfoList;
    }

    private void setRoundInfoList(List<Round> roundInfoList) {
        this.roundInfoList = roundInfoList;
    }
}
