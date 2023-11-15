package racing;

public class Validate {
    private static final int INPUT_THRESHOLD = 2;
    private static final int NAME_THRESHOLD = 5;

    public static void validInputNames(String names){
        if(!names.contains(",")){
            throw new IllegalArgumentException("PLEASE SEPARATE THE NAMES WITH COMMA(',')");
        }
    }

    public static void validName(String name){
        if(name.length() > NAME_THRESHOLD){
            throw new IllegalArgumentException("PLEASE INPUT VALID NAME (5 OR LESS CHARACTER)");
        }
    }

    public static void validInputMoveCount(int input) {
        if (input < INPUT_THRESHOLD) {
            throw new IllegalArgumentException("PLEASE INPUT APPROPRIATE NUMBER (OVER 1)");
        }
    }
}
