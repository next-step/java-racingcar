package racingcar;

import java.util.List;

public class RacingCar implements Comparable{
    private String name;
    private int runCount = 0;

    public RacingCar(String name){
        this.name = name;
    }
    public RacingCar(String name, int runCount){
        this.name = name;
        this.runCount = runCount;
    }

    public void run(){
        if(RacingRandom.randomizeTenBegger() >= 4){
            this.runCount++;
        }
    }

    @Override
    public int compareTo(Object o){
        RacingCar racingCar = (RacingCar) o;
        if(this.runCount > racingCar.runCount)//길이 비교
            return 1;
        if(this.runCount < racingCar.runCount)
            return -1;
        if(this.runCount == racingCar.runCount) {
            return 0;
        }
        return 0;
    }

    public int compareRacingCarListWithNum(List<RacingCar> racingCars){
        int tempMaxiMumNumber = 0;
        for(RacingCar racingCar2 : racingCars){
            if(compareTo(racingCar2) == 1){
                tempMaxiMumNumber++;
            }
        }
        return tempMaxiMumNumber;
    }

    public String whoAmI(){
        return name.toString();
    }
    public int getRunCount(){
        return runCount;
    }
}
