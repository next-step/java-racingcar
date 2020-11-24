package racingcarwinner;

public class Name {

    private final String string;

    public Name(String string){
        isOverNameLimit(string);
        isEmpty(string);
        this.string = string;
    }

    public String getString() {
        return string;
    }

    private void isOverNameLimit(String name){
        final int NAME_LIMIT = 5;

        if(name.length() > NAME_LIMIT){
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다");
        }
    }

    private void isEmpty(String name){
        if(name.isEmpty()){
            throw new IllegalArgumentException("자동차 이름 값을 넣어주세요");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        return string.equals(name.string);
    }

    @Override
    public int hashCode() {
        return string.hashCode();
    }
}
