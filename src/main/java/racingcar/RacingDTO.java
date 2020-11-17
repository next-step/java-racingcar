package racingcar;

import java.util.List;
import java.util.stream.Stream;

public class RacingDTO {
    private final String[] names;
    private final int attempts;

    public RacingDTO(String[] inputName, int attempts){
        this.names = inputName;
        this.attempts = attempts;
    }
    public static RacingDTO of(String[] names, int attempts){
        return new RacingDTO(names, attempts);
    }

    public static RacingDTO of(String inputName, int attempts){
        String[] names = Stream.of(inputName.split(",")).map(String::trim).toArray(String[]::new);
        return of(names, attempts);
    }

    public static RacingDTO of(List<String> inputName, int attempts){
        String[] names = inputName.toArray(new String[inputName.size()]);
        return of(names, attempts);
    }

    public String[] getNames(){
        return this.names;
    }
    public int getAttempts(){
        return this.attempts;
    }

}