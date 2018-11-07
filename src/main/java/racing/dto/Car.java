package racing.dto;

public class Car {

    /**
     * 할일 1. 움직이는 칸 계산
     * 할일 2. 움직인 칸 반환
     */

    public static int STEP_CONDITION_STANDARD = 4;

    private int position;

    public Car(int position) {
        this.position = position;
    }

    public void countPosition(int inputStandards){
        if(inputStandards < STEP_CONDITION_STANDARD){
            return;
        }

        ++position;
    }

    public int getPosition(){
        return position;
    }









}


