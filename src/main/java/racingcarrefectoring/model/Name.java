package racingcarrefectoring.model;

import racingcarrefectoring.exception.NameEmptyException;
import racingcarrefectoring.exception.OverTheLimitException;

public class Name {
    private final String string;

    public Name(String string){
        if(string.length() > 6) {
            throw new OverTheLimitException("이름은 6자를 넘을 수 없습니다");
        }

        if(string.isEmpty()){
            throw new NameEmptyException("이름은 값이 없을 수 없습니다");
        }

        this.string = string;
    }

    public String getString(){
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Name name = (Name) o;

        return string != null ? string.equals(name.string) : name.string == null;
    }

    @Override
    public int hashCode() {
        return string != null ? string.hashCode() : 0;
    }
}
