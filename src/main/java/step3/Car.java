package step3;

import java.util.Random;

public class Car {
    int carNum = 0;
    int[] carSpeed = {};
    Car(int num, int repeatCnt){
        this.carNum = num;
        this.carSpeed = new int[repeatCnt];

        setCarSpeed(repeatCnt);
    }

    private void setCarSpeed(int repeatCnt) {
        for(int i=0; i<repeatCnt; i++){
            carSpeed[i] = generateRandomNum(i);
        }
    }

    private int generateRandomNum(int index){
        Random random = new Random();
        //레이싱 시작 시 출발할 수 있도록 전진의 최소조건값인 4로 세팅
        if(index==0){
            return 4;
        }
        return random.nextInt(10);
    }
}
