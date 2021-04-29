package ugemang.nextstep.domain.car;

import ugemang.nextstep.domain.message.RacingGameMessageEnum;
import ugemang.nextstep.domain.status.RacingGameStatusEnum;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private List<String> distanceList;

    public Car(String name) {
        validateCarNameLength(name);
        this.name = name;
        this.distanceList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getDistanceList() {
        return distanceList;
    }

    private void validateCarNameLength(String name){
        if(name.length() == 0 || name.length() > 5){
            throw new IllegalArgumentException(String.format(RacingGameMessageEnum.E2.getMessage(), name.length()));
        }
    }

    public void changeGears(int speed){
        if(speed >= RacingGameStatusEnum.DRIVE.getVal()) {
            drive(speed);
            return;
        }
        stop();
    }

    public void drive(int speed){
        StringBuffer meter = new StringBuffer();
        for(int i=0;i<speed;i++){
            meter.append("-");
        }
        this.distanceList.add(meter.toString());
    }

    public void stop(){
        this.distanceList.add("-");
    }

    public String getDistance(int index){
        return getDistanceList().get(index);
    }

    public Integer getTotalDistance(){
        int totalDistance = 0;
        for(String i : this.distanceList){
            totalDistance += i.length();
        }
        return totalDistance;
    }
}
