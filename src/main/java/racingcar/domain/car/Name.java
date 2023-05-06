package racingcar.domain.car;

public class Name {

    private final static int LENGTH_LIMIT = 5;
    private final String name;

    private Name(String name){
        this.name = name;
    }

    public static Name from(String name){
        validateName(name);

        return new Name(name);
    }

    public String getName(){
        return name;
    }

    private static void validateName(String name) {
        validateNotBlank(name);
        validateLength(name);
    }

    private static void validateNotBlank(String name) {
        if(name == null || name.isBlank()){
            throw new RuntimeException("자동차 이름은 항상 있어야 합니다!");
        }
    }

    private static void validateLength(String name) {
        if(name.length() > LENGTH_LIMIT){
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없습니다! 잘못된 이름"+ name);
        }
    }
}
