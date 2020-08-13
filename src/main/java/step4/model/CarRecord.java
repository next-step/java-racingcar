package step4.model;

import java.util.ArrayList;
import java.util.List;

public class CarRecord {

    private List<Integer> recordList = new ArrayList<>();
    private String carName;

    public CarRecord(String carName) {
        this.carName = carName;
    }

    public List<Integer> getRecordList() {
        return recordList;
    }

    public String getCarName() {
        return carName;
    }

    public void resultRecording(int position) {
        recordList.add(position);
    }
}
