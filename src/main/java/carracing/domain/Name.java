package carracing.domain;


public class Name {

    private String name;

    public Name(String name) {
        if ("".equals(name.trim()))
            throw new IllegalArgumentException("자동차 이름을 입력해 주세요.");

        if (name.length() < 1 || name.length() > 5)
            throw new IllegalArgumentException("이름은 1자 이상, 5자를 이하로 입력되어야 합니다.");

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
