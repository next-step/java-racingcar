package racingcar;

import java.util.Random;

public class MoveCheckor{

    //기준치 이상 여부 확인
    public boolean checkOverBaseline(){
        boolean canMove = false;
        Random random = new Random();
        int randomNum = random.nextInt(10);
        if(randomNum >=4){
            canMove = true;
        }

        return canMove;
    }

    //난수에 따른 이동 및 기록
    public void moveAndStop(Car car, int attempts){

        for(int i=0;i<attempts;i++){
            if(this.checkOverBaseline()){
                car.move();
            }
            car.recordDistance();
        }

    }
}
