package racingcar;

public class RacingDTO {
    private String[] names;
    private int attempts;

    public RacingDTO(String inputName, int attempts){
        this.names = inputName.split(",");
        this.attempts = attempts;
    }

    public String[] getNames(){
        return this.names;
    }
    public int getAttempts(){
        return this.attempts;
    }

}