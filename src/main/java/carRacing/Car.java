package carRacing;

import java.util.Random;

public class Car {
    CarInfo[] carInfo;

    public void inputGameInfo(String carNum, int gameCount) {
        int num = Integer.parseInt(carNum);
        carInfo = new CarInfo[num];
        for(int i = 0; i < carInfo.length; i++) {
            carInfo[i] = new CarInfo();
        }
        System.out.println("실행 결과");
        for(int j = 0; j < gameCount; j++) {
            playGame(carInfo);
        }
    }

    public void playGame(CarInfo[] carInfo){
        Random random = new Random();
        int n = 0;
        for(int i = 0; i < carInfo.length; i++){
            n = random.nextInt(10);
            if (n >= 4) carInfo[i].junjinUp();
        }
        playResult();
        System.out.println();
    }

    private void playResult() {
        for(int i = 0; i < carInfo.length; i++) {
            outputCar(carInfo[i]);
        }
    }

    private void outputCar(CarInfo c) {
        int count = c.getJunjin();
        for(int i = 0; i < count; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
