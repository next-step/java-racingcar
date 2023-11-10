package study;

import lombok.*;

import java.util.ArrayList;

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

    //random number 저장용
    private ArrayList<Integer> randomsByStep;

    public RacingCar(String carName, int drive, ArrayList<Integer> randomsByStep) {
        this.carName = carName;
        this.drive = drive;
        this.randomsByStep = randomsByStep;
    }

    public String carName() {
        return this.carName;
    }

    public String move(int stepNo){

        String moveStr = BLANK;

        for(int i=0; i<=stepNo; i++){

            if(randomsByStep.get(i)>= CONDITION_VAL){
                moveStr+= DASH;
            }
        }

        return this.carName() + " : " + moveStr;
    }

    boolean checkChampion(int val){
        if(val == this.drive){
            return true;
        }
        return false;
    }

    int maxStep(int val){

        if(val<this.drive){
            return this.drive;
        }
        return val;
    }



}




