package step2;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(int number){
        validate(number);
        this.number = number;
    }



    public int getNumber() {
        return number;
    }

    public void validate(int number){
        if(number < 0){
            throw new IllegalArgumentException("음수값은 허용되지 않습니다!");
        }
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(! (o instanceof  Number)){
            return false;
        }

        Number that = (Number) o;
        if(number != that.getNumber()){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode(){
        return Objects.hash(number);
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }
}
