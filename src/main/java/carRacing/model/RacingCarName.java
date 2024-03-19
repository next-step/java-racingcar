package carRacing.model;

public class RacingCarName {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public RacingCarName(String name){
        checkingName(name);
        this.name = name;
    }

    private static void checkingName(String value){
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }

        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 최대 5자리까지 입력가능합니다. " + value);
        }
    }

    public String nameValue(){
        return this.name;
    }
}
