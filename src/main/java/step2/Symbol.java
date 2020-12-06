package step2;

import java.util.Objects;

public class Symbol {

    private String value;

    public Symbol(String value) {
        if(!value.equals("+") && !value.equals("-") &&  !value.equals("/") && !value.equals("*")){
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol symbol = (Symbol) o;
        return value.equals(symbol.value);
    }

}
