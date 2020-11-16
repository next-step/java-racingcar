package racingcar;

import java.util.List;

public class RacingDTO {
    private final String[] names;
    private final int attempts;

    public RacingDTO(String inputName, int attempts){
        String[] tempName = inputName.split(",");
        names = new String[tempName.length];
        for(int i=0;i<tempName.length;i++){
            this.names[i] = tempName[i].trim();
        }
        this.attempts = attempts;
    }
    public RacingDTO(String[] inputName, int attempts){
        this.names = inputName;
        this.attempts = attempts;
    }
    public RacingDTO(List<String> inputName, int attempts){
        this.names = new String[inputName.size()];
        for(int i=0;i<inputName.size();i++){
            this.names[i] = inputName.get(i);
        }
        this.attempts = attempts;
    }

    public String[] getNames(){
        return this.names;
    }
    public int getAttempts(){
        return this.attempts;
    }

}