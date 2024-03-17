package carRacing.model;

public class RacingCarName {
    private String name;
    private static final int MAX_LENGTH = 5;

    public RacingCarName(String name){
        checkingName(name);
        this.name = name;
    }

    private static void checkingName(String value){
        if(value.isBlank()){
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }

        if (value.length() > MAX_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 최대 5자리까지 입력가능합니다. " + value);
        }
    }

    public String theCarName(){
        return this.name;
    }
}
