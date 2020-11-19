package racingcar.domain.car;

import racingcar.domain.move.MoveStrategy;

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
    public int getRecord(int attempt){
        return records.get(attempt);
    }

    public String getName(){
        return this.name;
    }


    //자동차 이동
    public void move(MoveStrategy moveStrategy){
        if(moveStrategy.canMove()){
            distance+=1;
        }
        records.add(distance);
    }

    //자동차 최종 기록
    public int getLastRecord(){
        return records.get(records.size()-1);
    }

}