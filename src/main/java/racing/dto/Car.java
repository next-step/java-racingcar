package racing.dto;

public class Car {

    /**
     * 할일 1. 움직이는 칸 계산
     * 할일 2. 움직인 칸 반환
     */

    public static int STEP_CONDITION_STANDARD = 4;

    private int position;
    private String name;
/*
    public Car(int position) {
        this.position = position;
    }
*/

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    public void countPosition(int inputStandards){
        if(inputStandards >= STEP_CONDITION_STANDARD){
            ++position;
        }
    }

    public boolean isNeedPosition(int standardPosition){
        if(standardPosition == getPosition()){
            return true;
        }
        return false;
    }

    public int getPosition(){
        return position;
    }

    public String getName() {
        return name;
    }
}


