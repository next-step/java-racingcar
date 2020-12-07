package carRacing;

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

    }
}
