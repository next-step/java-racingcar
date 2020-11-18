package racingcar.domain.racing;

public class RacingDTO {
    private final String names;
    private final int attempts;

    public RacingDTO(String inputName, int attempts){
        this.names = inputName;
        this.attempts = attempts;
    }

    public String getNames(){
        return this.names;
    }
    public int getAttempts(){
        return this.attempts;
    }

}