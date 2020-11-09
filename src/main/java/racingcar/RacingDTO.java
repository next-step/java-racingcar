package racingcar;

public class RacingDTO {
    private int counts;
    private int attempts;

    public RacingDTO(int counts, int attempts){
        this.counts = counts;
        this.attempts = attempts;
    }

    public int getCounts(){
        return this.counts;
    }
    public int getAttempts(){
        return this.attempts;
    }

}
