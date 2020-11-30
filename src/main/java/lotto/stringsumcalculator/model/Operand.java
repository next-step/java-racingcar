package lotto.stringsumcalculator.model;

public class Operand {

    private final int value;

    public Operand(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operand operand = (Operand) o;

        return value == operand.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
