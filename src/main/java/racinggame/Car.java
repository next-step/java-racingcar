package racinggame;

import racinggame.rule.RacingRule;

public class Car {

    private String name;
    private int location;

    public Car(String name){
        this.name = name;
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
