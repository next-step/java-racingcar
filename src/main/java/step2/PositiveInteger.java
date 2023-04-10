package step2;

public class PositiveInteger {

    private final int value;

    private PositiveInteger(String value){
        this.value = Integer.parseInt(value);
    }
    public static PositiveInteger from(String value){
        PositiveInteger ps = new PositiveInteger(value);
        if(ps.value < 0){
            throw new RuntimeException();
        }
        return ps;
    }

    public int getValue(){
        return value;
    }
}
