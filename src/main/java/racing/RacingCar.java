package racing;


import racing.model.RacingModel;

public class RacingCar {

    public void race(RacingModel racingModel) {
        for(int carNumber=0; carNumber<racingModel.getRacingModelMap().size(); carNumber++) {
            setMove(carNumber, racingModel);
        }
    }

    public void setMove(int carNumber, RacingModel racingModel) {
        if (isMove(getRandomValue())) {
            int moveCount = racingModel.getRacingModelMap().get(carNumber).intValue();
            racingModel.setRacingModelMap(carNumber, ++moveCount);
        }
    }

    public int getRandomValue() {
        return (int)(Math.random() * 9);
    }

    public boolean isMove(int randomValue) {
        if (randomValue >= 4) {
            return true;
        }
        return false;
    }
}
