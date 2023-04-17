package study.step4;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;

    String name;

    public Name(String name) {
        checkName(name);
        this.name = name;
    }

    private void checkName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("이름이 다섯자 이상입니다.");
        }
    }

    public String getName() {
        return name;
    }

}
