package step4.model;

public class InputRacingCarSplitStrategy implements SplitStrategy {

    private static final String COMMA_DELIMITER = ",";

    @Override
    public String[] split(String inputRacingCarStr) {
        return inputRacingCarStr.split(COMMA_DELIMITER);
    }
}
