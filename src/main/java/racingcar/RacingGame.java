package racingcar;


import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int tryCnt;
    private List<RacingCar> racingCarList;

    public int setRacingCarCnt(int racingCarCnt) {
        racingCarList = new ArrayList<>();
        for (int i = 0; i < racingCarCnt; i++) {
            racingCarList.add(new RacingCar());
        }
        return racingCarList.size();
    }

    public int getTryCnt() {
        return tryCnt;
    }

    public void setTryCnt(int tryCnt) {
        this.tryCnt = tryCnt;
    }

    public void setRacingCar() {

    }

    public void setRandomValue() {
        for (RacingCar racingCar : racingCarList) {
            int value = racingCar.checkRandom();
            System.out.println(getRandomString(value));
        }
        System.out.println("\n");
    }

    public String getRandomString(int coord) {
        StringBuilder coordString = new StringBuilder();
        for (int i = 0; i < coord; i++) {
            coordString.append("- ");
        }
        return coordString.toString();
    }

    public void executionResult() {
        for (int i = 0; i < tryCnt; i++) {
            setRandomValue();
        }
    }


}
