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

    public void setCarNum(int carNum) {
        this.carNum = carNum;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
