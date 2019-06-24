package domain;

public class GameResult {
    String carName;
    String[] result;

    public GameResult(String name, int time, String separator) {
        this.carName = name;
        this.result = new String[time];
        this.result[0] = separator;
    }

    public void record(String gameResult, int time) {
        this.result[time] = gameResult;
    }

    public String getEachResult(int time) {
        return this.result[time];
    }
}