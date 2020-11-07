package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Car {
    public int distance;
    public List<String> recordDistance;

    public Car(){
        this.distance = 0;
        this.recordDistance = new ArrayList<String>();
    }

    //자동차 난수 발생
    public void decision(int attempts){
        int randomNum;
        Random random = new Random();
        for(int i=0;i<attempts;i++){
            randomNum = random.nextInt(10);
            if(randomNum >=4){
                this.distance+=1;
            }
            move();
        }
    }

    //난수 발생 결과에 따른 이동 결과 저장
    public void move(){
        int tempDistance = this.distance;
        String distanceToStr="";

        while(tempDistance!=0){
            distanceToStr+="-";
            tempDistance-=1;
        }
        recordDistance.add(distanceToStr);
    }

}
