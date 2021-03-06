package racingcar.dto;

public class RacingCarGameRequest {

    private int playCount;

    private String[] carNameArray;

    public RacingCarGameRequest(int playCount, String[] carNameArray) {
        this.playCount = playCount;
        this.carNameArray = carNameArray;
    }

    public int getPlayCount() {
        return playCount;
    }

    public String[] getCarNameArray() {
        return carNameArray;
    }
}
