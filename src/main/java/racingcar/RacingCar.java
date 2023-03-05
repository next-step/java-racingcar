package racingcar;

import java.util.List;

public class RacingCar implements Comparable{
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

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append(name.toString());
        sb.append(" : ");
        int startCount = 0;
        while( startCount < runCount){
            sb.append('-');
            startCount++;
        }
        System.out.println(sb.toString());
    }

    @Override
    public int compareTo(Object o){
        RacingCar racingCar = (RacingCar) o;
        if(this.runCount > racingCar.runCount)//길이 비교
            return 1;
        else if(this.runCount < racingCar.runCount)
            return -1;
        else {
            return 0;
        }
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
}
