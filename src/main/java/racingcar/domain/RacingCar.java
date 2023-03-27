package racingcar.domain;

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

    public void runWithNoCondition(){
        this.runCount++;
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

    public int compareRacingCarListWithNum(List<RacingCar> racingCars, int tempMaxiMumNumber){
        for(RacingCar compareTargetRacingCar : racingCars){
            tempMaxiMumNumber = compareAndPlusNumber(compareTargetRacingCar, tempMaxiMumNumber);
        }
        return tempMaxiMumNumber;
    }

    private int compareAndPlusNumber(RacingCar compareTargetRacingCar, int tempMaxiMumNum){
        if(compareTo(compareTargetRacingCar) == 1){
            return tempMaxiMumNum + 1;
        }
        return tempMaxiMumNum;
    }

    public String whoAmI(){
        return name.toString();
    }
    public int getRunCount(){
        return runCount;
    }
}
