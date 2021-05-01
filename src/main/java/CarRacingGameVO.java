public class CarRacingGameVO {
    private Integer racingLeap;
    private final Integer carNameLengthLimit = 5;
    private final Integer carForwardStopRandomBound = 10;
    private final Integer carForwardLimit = 4;
    private final String carNameSplitDelimiter = ",";

    public Integer getRacingLeap() {
        return racingLeap;
    }

    public Integer getCarNameLengthLimit() {
        return carNameLengthLimit;
    }

    public Integer getCarForwardStopRandomBound() {
        return carForwardStopRandomBound;
    }

    public Integer getCarForwardLimit() {
        return carForwardLimit;
    }

    public String getCarNameSplitDelimiter() {
        return carNameSplitDelimiter;
    }

    public void setRacingLeap(Integer racingLeap) {
        this.racingLeap = racingLeap;
    }
}
