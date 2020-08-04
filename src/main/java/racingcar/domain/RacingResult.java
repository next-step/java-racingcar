package racingcar.domain;

public final class RacingResult  {
    private final String prefix;
    private final int totalMileage;

    RacingResult(String prefix, int totalMileage) {
        this.prefix = prefix;
        this.totalMileage = totalMileage;
    }

    public static RacingResult defaultResult(int totalMileage){
        return new RacingResult("", totalMileage);
    }

    public static RacingResult namedResult(String name, int totalMileage){
        return new RacingResult(name, totalMileage);
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isEmptyPrefix(){
        return "".equals(getPrefix());
    }

    public int getTotalMileage() {
        return totalMileage;
    }
}
