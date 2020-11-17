package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int distance;
    private final List<Integer> records;

    public Car(String name){
        this.name = name;
        this.distance = 0;
        this.records = new ArrayList<>();
    }
    public List<Integer> getRecordList(){
        return records;
    }

    public String getName(){
        return this.name;
    }

    //자동차 이동
    public void move(){
        RandomNumber randomNumber = new RandomNumber();
        int randomNum = randomNumber.makeNumber();
        distance += randomNumber.isBigger(randomNum);
    }
    //자동차 이동 기록
    public void recordDistance(){
        records.add(distance);
    }

    //자동차 최종 기록
    public int getLastRecord(){
        return records.get(records.size()-1);
    }

}