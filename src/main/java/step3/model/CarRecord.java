package step3.model;

import java.util.ArrayList;
import java.util.List;

public class CarRecord {

    private List<Integer> recordList = new ArrayList<>();

    public void resultRecording(int position){
        System.out.println(position);
        recordList.add(position);
    }

}
