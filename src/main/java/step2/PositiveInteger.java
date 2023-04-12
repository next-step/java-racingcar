package step2;

public class PositiveInteger {

    private final int value;

    private PositiveInteger(int value){
        this.value = value;
    }
    public static PositiveInteger from(String value){
        validate(value);
        PositiveInteger ps = new PositiveInteger(Integer.parseInt(value));

        return ps;
    }

    public int getValue(){
        return value;
    }

    private static void validate(String value){
        try{
            Integer.parseInt(value);
        }catch (NumberFormatException e){
            throw new RuntimeException(e);
        }
    }
}
