package racingcar.dto;

import java.util.List;

public class RacingCarGameRequest {

    private int playCount;

    private int carNumber;

    public RacingCarGameRequest(int playCount,int carNumber) {
        this.playCount = playCount;
        this.carNumber = carNumber;
    }

    public int getPlayCount() {
        return playCount;
    }

    public int getCarNumber() {
        return carNumber;
    }
}
