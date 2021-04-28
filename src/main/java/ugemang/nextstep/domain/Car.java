package ugemang.nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private List<Integer> distanceList;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
        this.distanceList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void validateCarNameLength(String name){
        if(name.length() == 0 || name.length() > 5){
            throw new IllegalArgumentException(String.format("자동차 이름의 길이 조건이 맞지 않습니다.", name.length()));
        }
    }

    public void changeGears(){
        int distance = getDistance();
        if(distance >= 4) {
            drive(distance);
        }
        stop(0);
    }

    private Integer getDistance(){
        return (int)(Math.random() * (10));
    }

    public void drive(int meter){
        this.distanceList.add(meter);
    }

    public void stop(int meter){
        this.distanceList.add(meter);
    }

    public Integer getTotalDistance(){
        Integer totalDistance = new Integer(0);
        for(Integer i : this.distanceList){
            totalDistance += i;
        }
        return totalDistance;
    }
}
