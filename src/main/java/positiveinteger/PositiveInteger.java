package positiveinteger;

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

    public static PositiveInteger from(int value){
        validate(value);
        PositiveInteger ps = new PositiveInteger(value);
        return ps;
    }

    public int getValue(){
        return value;
    }

    private static void validate(String value){
        try{
            validate(Integer.parseInt(value));
        }catch (NumberFormatException e){
            throw new RuntimeException("입력은 숫자만 가능합니다! "+value, e);
        }
    }

    private static void validate(int value){
        if(value < 1){
            throw new RuntimeException("입력은 양수만 가능합니다! "+value);
        }
    }
}
