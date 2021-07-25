package racing.model;

import java.util.ArrayList;
import java.util.List;

public class RacingModel {
    private List<CarModel> carList;
    private int playCount;

   public void settingGame(int carCount, int playCount) {
        carList = new ArrayList<>();
        for(int count=0; count<carCount; count++) {
            CarModel carModel = new CarModel();
            carList.add(carModel);
        }

        this.playCount = playCount;
    }


    public List<CarModel> participants() {
        return this.carList;
    }

    public Boolean endGame(int gameCount) {
        return this.playCount == gameCount ? true : false;
    }
}
