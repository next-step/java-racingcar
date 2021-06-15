package domain;

public class CarConstant {

    private CarConstant(){
        throw new AssertionError();
    }

    public static final int FORWARD_NUM = 4;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String MOVE_REGEX_HYPHEN = "-";
    public static final int INIT_POSITION = 0;
}
