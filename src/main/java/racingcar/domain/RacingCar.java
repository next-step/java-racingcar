package racingcar.domain;

public class RacingCar {

    private int travelledDistance;

    private String name;
    
    private final RacingCarGameRule racingCarGameRule;

    public RacingCar(RacingCarGameRule racingCarGameRule, String name) {
        racingCarGameRule.validateWhetherCarNameLengthLimit(name);
        this.racingCarGameRule = racingCarGameRule;
        this.name = name;
    }

    public void move(){
        if(racingCarGameRule.isCarMovable()){
            travelledDistance++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getTravelledDistance() {
        return travelledDistance;
    }
    
}
