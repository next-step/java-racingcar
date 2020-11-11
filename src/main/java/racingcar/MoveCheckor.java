package racingcar;

import java.util.Random;

public class MoveCheckor{

    final private int baseLineNum = 4;
    private int randomNum;

    public int getBaseLineNum(){
        return this.baseLineNum;
    }

    public int getRandomNum(){
        return this.randomNum;
    }

    //기준치 이상 여부 확인
    public boolean checkOverBaseLine(){
        boolean canMove = false;
        Random random = new Random();
        this.randomNum = random.nextInt(10);
        if(this.randomNum >= this.baseLineNum){
            canMove = true;
        }

        return canMove;
    }

    //난수에 따른 이동 및 기록
    public void moveAndStop(Car car){
        if(this.checkOverBaseLine()){
            car.move();
        }
        car.recordDistance();
    }
}
