package carRacing;

import java.util.Random;

public class Car {
    CarInfo[] carInfo;

    public void inputGameInfo(String carNum, int gameCount) {
        int num = Integer.parseInt(carNum);
        for(int i = 0; i < num; i++) {
            carInfo = new CarInfo[i];
        }
        for(int j = 0; j < gameCount; j++) {
            playGame(carInfo);
        }
    }

    public void playGame(CarInfo[] carInfo){
        Random random = new Random();
        int n = 0;
        for(int i = 0; i < carInfo.length; i++){
            n = random.nextInt(10);
            if (n > = 4) carInfo[i].junjiUp();
        }
    }
}
