package study1.step3;

import java.util.*;

public class Race {
    private int raceCnt = 0;
    private CarList carList;
    private RaceBoard board;

    private void setting(){
        RaceSetting raceSetting = new RaceSetting();
        int carCnt = raceSetting.getCarCnt();
        this.carList = new CarList(carCnt, new MoveDecision());
        this.raceCnt = raceSetting.getRaceCnt();
        raceSetting.close();
    }
    public void race(){
        setting();

        board = new RaceBoard();
        for(int i = 0; i < raceCnt; i++){
            carList.race();
            board.show(carList.getCarList());
        }
    }
}
