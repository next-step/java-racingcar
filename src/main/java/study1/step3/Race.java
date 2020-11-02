package study1.step3;

import java.util.*;

public class Race {
    private int raceCnt = 0;
    private CarList carList;

    private void raceSetting(){
        RaceSetting settings = new RaceSetting();
        int carCnt = settings.getCarCnt();
        this.carList = new CarList(carCnt);
        this.raceCnt = settings.getRaceCnt();
        settings.close();
    }
    public void race(){
        raceSetting();

        RaceBoard board = new RaceBoard();
        for(int i = 0; i < raceCnt; i++){
            carList.race();
            board.show(carList.getCarList());
        }
    }
}
