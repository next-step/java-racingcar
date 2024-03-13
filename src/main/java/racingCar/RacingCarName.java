package racingCar;

public class RacingCarName {
    private String name;
    private static final int MAX_NAME_LEN = 5;

    public RacingCarName(String name){
        checkUsableName(name);
        this.name = name;
    }

    private static void checkUsableName(String value){
        if(value.isBlank()){
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }

        if (value.length() > MAX_NAME_LEN){
            throw new IllegalArgumentException("너무 긴 길이의 이름" + value);
        }
    }

    public String whatIsCarName(){
        return this.name;
    }
}
