package racinggame.car;

import racinggame.rule.RacingRule;

public class Car {

    private String name;
    private int location;

    public Car(String name, int location){
        this.name = name;
        this.location = location;
    }

    public int getLocation(){
        return location;
    }

    public String getName(){
        return name;
    }

    public boolean equalsPosition(int maxLocation) {
        return getLocation() == maxLocation;
    }

    public void move(RacingRule racingRule) {
        if(racingRule.isPossibleMove()){
            this.location++;
        }
    }
}
