package racingcar.domain;

public final class RacingResult  {
    public static final String DEFAULT_RACING_CAR_NAME = "";
    private final String racingCarName;
    private final int totalMileage;

    RacingResult(String racingCarName, int totalMileage) {
        this.racingCarName = racingCarName;
        this.totalMileage = totalMileage;
    }

    public static RacingResult defaultResult(int totalMileage){
        return new RacingResult(DEFAULT_RACING_CAR_NAME, totalMileage);
    }

    public static RacingResult namedResult(String name, int totalMileage){
        return new RacingResult(name, totalMileage);
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public boolean isNotNamedRacingResult(){
        return DEFAULT_RACING_CAR_NAME.equals(getRacingCarName());
    }

    public int getTotalMileage() {
        return totalMileage;
    }
}
