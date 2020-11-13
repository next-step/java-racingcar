package racingcar.step3.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created : 2020-11-09 오전 8:25.
 * Developer : Seo.
 */
public class Record {
    private final List<Map<String, Integer>> totalRecords;

    public Record() {
        this.totalRecords = new ArrayList<>();
    }

    public void setTotalRecords(Map<String, Integer> turnRecords) {
        totalRecords.add(turnRecords);
    }

    public List<Map<String, Integer>> getTotalRecords() {
        return this.totalRecords;
    }

}
