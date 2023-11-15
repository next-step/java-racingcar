package racing.domain;

public class Name {
    private static final String ERROR_MESSAGE_OF_EXCEED_NAME_LENGTH = "자동차 이름 허용 길이를 초과하였습니다.";
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Name(String name){
        validNameLength(name);
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    private void validNameLength(String name){
        if(name.length() > MAX_NAME_LENGTH) throw new IllegalArgumentException(ERROR_MESSAGE_OF_EXCEED_NAME_LENGTH);
    }
}
