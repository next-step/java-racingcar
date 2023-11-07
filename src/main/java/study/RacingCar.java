package study;

import lombok.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

@NoArgsConstructor
public class RacingCar {

    public static final int ZERO = 0;
    public static final String BLANK = "";
    public static final String DASH = "-";
    public static final int CONDITION_VAL = 4;

    // 자동차 명
    private String carName = BLANK;

    // 자동차 이동 횟수
    private int drive = ZERO;

    //레이싱 횟수
    private int loopCount = ZERO;

    //random number 저장용
    private ArrayList<Double> randomsByStep;

    public RacingCar(String carName, int drive, int loopCount, ArrayList<Double> randomsByStep) {
        this.carName = carName;
        this.drive = drive;
        this.loopCount = loopCount;
        this.randomsByStep = randomsByStep;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getDrive() {
        return drive;
    }

    public void setDrive(int drive) {
        this.drive = drive;
    }

    public int getLoopCount() {
        return loopCount;
    }

    public void setLoopCount(int loopCount) {
        this.loopCount = loopCount;
    }

    public ArrayList<Double> getRandomsByStep() {
        return randomsByStep;
    }

    public void setRandomsByStep(ArrayList<Double> randomsByStep) {
        this.randomsByStep = randomsByStep;
    }

    public void move(int stepNo){

        String moveStr = BLANK;

        for(int i=0; i<=stepNo; i++){

            if(randomsByStep.get(i)>= CONDITION_VAL){
                moveStr+= DASH;
            }
        }

        System.out.println(this.getCarName() + " : " + moveStr);
    }

}




