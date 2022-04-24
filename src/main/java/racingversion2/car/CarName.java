package racingversion2.car;

public class CarName {

    private final static String INVALID_CAR_NAME_LENGTH_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다.";
    private final static int MAXIMUM_CAR_NAME_LENGTH = 5;

    private String name;

    private CarName (String name){
        this.name = name;
    }

    public static CarName of(String name) {
        if(name.length() > MAXIMUM_CAR_NAME_LENGTH){
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH_MESSAGE);
        }
        return new CarName(name);
    }

    public String getName() {
        return this.name;
    }
}
