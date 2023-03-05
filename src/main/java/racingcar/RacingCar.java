package racingcar;

public class RacingCar {
    private String name;
    private int runCount = 0;

    public RacingCar(String name){
        this.name = name;
    }

    public void run(){
        if(RacingRandom.randomizeTenBegger() >= 4){
            this.runCount++;
        }
    }
}
