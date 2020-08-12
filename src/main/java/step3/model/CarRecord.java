package step3.model;

import java.util.ArrayList;
import java.util.List;

public class CarRecord {

    private List<Integer> recordList = new ArrayList<>();

    public void resultRecording(int position) {
        recordList.add(position);
    }

    public List<Integer> getRecordList() {
        return recordList;
    }
}
