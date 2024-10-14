package racing.domain;

public class UserInput {

    private int totalCars;
    private String totalCarNames;
    private int totalRacingCounts;

    public UserInput(int totalCars, int totalRacingCounts) {
        this.totalCars = totalCars;
        this.totalRacingCounts = totalRacingCounts;
    }

    public UserInput(String totalCarNames, int totalRacingCounts) {
        this.totalCarNames = totalCarNames;
        this.totalRacingCounts = totalRacingCounts;
    }

    public int getTotalCars() {
        return this.totalCars;
    }

    public String getTotalCarNames() {
        return totalCarNames;
    }

    public int getTotalRacingCounts() {
        return totalRacingCounts;
    }
}

