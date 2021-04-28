package ugemang.nextstep.domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private List<Integer> distanceList;

    public Car(String name) {
        this.name = name;
        this.distanceList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getDistanceList(){
        return this.distanceList;
    }

    public int changeGears(int value){
        if(value >= 4) {
            return drive(value);
        }
        return stop(0);
    }

    public int drive(int meter){
        this.distanceList.add(meter);
        return meter;
    }

    public int stop(int meter){
        this.distanceList.add(meter);
        return meter;
    }

    public Integer getTotalDistance(){
        Integer totalDistance = new Integer(0);
        for(Integer i : this.distanceList){
            totalDistance += i;
        }
        return totalDistance;
    }
}
