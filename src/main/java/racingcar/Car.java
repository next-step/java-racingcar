package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    private String name;
    private int distance;
    private List<Integer> recordList;

    public Car(String name){
        this.name = name;
        this.distance = 0;
        this.recordList = new ArrayList<Integer>();
    }
    public List<Integer> getRecordList(){
        return this.recordList;
    }

    public String getName(){
        return this.name;
    }

    //자동차 이동
    public void move(){
        this.distance +=1;
    }
    //자동차 이동 기록
    public void recordDistance(){
        this.recordList.add(this.distance);
    }

    //자동차 최종 기록
    public int getLastRecord(){
        return this.recordList.get(this.recordList.size()-1);
    }

}