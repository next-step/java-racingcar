package step4.racing;

import step4.racing.inout.OutPutView;

public class Name {
    private static final int LIMIT_NAME_LENGTH = 5;
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name defaultOf(String name) {
        if (name.length() > LIMIT_NAME_LENGTH) {
            throw new IllegalArgumentException("이름 길이 제한을 초과했습니다.");
        }
        return new Name(name);
    }

    @Override
    public String toString() {
        return "Name{" +
                "name='" + name + '\'' +
                '}';
    }

    public void print(OutPutView outPutView) {
        outPutView.printName(name);
    }
}
