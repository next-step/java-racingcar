package racingcar.model;

public class InputModel {
    private int carNum;
    private int times;

    public InputModel(int carNum, int times) {
        this.carNum = carNum;
        this.times = times;
    }

    public int getCarNum() {
        return carNum;
    }

    public int getTimes() {
        return times;
    }
}
