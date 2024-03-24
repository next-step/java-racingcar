public class Name {
    private String name;
    private final int NAME_MIN_SIZE = 1;
    private final int NAME_MAX_SIZE = 5;

    public Name(String name) {
        if (name.length() < NAME_MIN_SIZE || name.length() > NAME_MAX_SIZE) {
            throw new RuntimeException("이름은 1~5글자이어야 합니다.");
        }
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
