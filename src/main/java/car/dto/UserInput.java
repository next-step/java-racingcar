package car.dto;

public class UserInput {
    public final String[] carNameList;
    public final int totalRound;

    public UserInput(String[] carNameList, int totalRound) {
        this.carNameList = carNameList;
        this.totalRound = totalRound;
    }
}
