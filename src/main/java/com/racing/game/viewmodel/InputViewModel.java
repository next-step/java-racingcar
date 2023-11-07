package com.racing.game.viewmodel;

import com.racing.game.vo.CarCount;
import com.racing.game.vo.TryCount;

public class InputViewModel {

    private CarCount carCount;
    private TryCount tryCount;

    public void saveCarCount(CarCount carCount) {
        this.carCount = carCount;
    }

    public void saveTryCount(TryCount tryCount) {
        this.tryCount = tryCount;
    }

    public CarCount carCount() {
        return carCount;
    }

    public TryCount tryCount() {
        return tryCount;
    }

}
