package racingcar.dto;

import java.util.List;

public class RacingCarGameRequest {

    private int playCount;

    private List<String> carNameList;

    public RacingCarGameRequest(int playCount, List<String> carNameList) {
        this.playCount = playCount;
        this.carNameList = carNameList;
    }

    public int getPlayCount() {
        return playCount;
    }

    public List<String> getCarNameList() {
        return carNameList;
    }
}
