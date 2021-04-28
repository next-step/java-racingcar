package ugemang.nextstep.domain;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private String name;
    private Map<Integer, Integer> distanceList;

    public Car(String name) {
        this.name = name;
        this.distanceList = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Integer> getDistanceList(){
        return this.distanceList;
    }

    public void drive(int turn, int meter){
        this.distanceList.put(turn, meter);
    }

    public void stop(int turn){
        this.distanceList.put(turn, 0);
    }

    public Integer getTotalDistance(){
        int totalDistance = 0;
        for(Integer i : this.distanceList.values()){
            totalDistance += i;
        }
        return totalDistance;
    }
}
