package racing;

public class Driver {

    private final String name;

    public Driver(String name) {
        this.validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if(name == null || name.trim().isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("참가자의 이름이 유효하지 않습니다.");
        }
    }

    public String getName() {
        return this.name;
    }
}
