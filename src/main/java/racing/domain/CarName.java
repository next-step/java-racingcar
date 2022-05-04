package racing.domain;

public class CarName {
    private final String name;


    public CarName(String name) {
        validate(name);
        this.name = name;
    }


    public void validate(String name){
        if(name.length() > 5){
            throw new IllegalArgumentException("이름의 길이는 5글자를 초과할 수 없습니다.");
        }
    }

    public String getName(){
        return name;
    }
}
