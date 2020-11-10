package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    public int distance;
    public List<Integer> recordList;

    public Car(){
        this.distance = 0;
        this.recordList = new ArrayList<Integer>();
    }

    //자동차 이동
    public void move(){
        this.distance +=1;
    }
    //자동차 이동 기록
    public void recordDistance(){
        this.recordList.add(this.distance);
    }

}
