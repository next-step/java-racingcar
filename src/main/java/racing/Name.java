package racing;

import racing.inout.OutPutView;

public class Name {
    private final String name;

    private Name(String name) {
        this.name = name;
    }

    public static Name defaultOf(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
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
