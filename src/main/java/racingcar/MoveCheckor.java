package racingcar;

import java.util.Random;

public class MoveCheckor {

    //난수 확인
    public boolean checkNumber(){
        boolean canMove = false;
        Random random = new Random();
        int randomNum = random.nextInt(10);
        if(randomNum >=4){
            canMove = true;
        }

        return canMove;
    }

    //난수에 따른 이동 및 정지 결정
    public void moveAndStop(Car car, int attempts){

        for(int i=0;i<attempts;i++){
            if(this.checkNumber()){
                car.distance+=1;
            }
            car.move();
        }

    }
}
