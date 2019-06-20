package racing.vo;

public class GameMakingInfo {
    private String carNames;
    private int time;
    
    public GameMakingInfo(String carNames, int time) {
        this.carNames = carNames;
        this.time = time;
    }
    
    public String getCarNames() {
        return carNames;
    }
    
    public int getTime() {
        return time;
    }
}
