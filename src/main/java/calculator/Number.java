package calculator;

public class Number {

    private final Double value;

    public Number(String number){
        this.value = Double.parseDouble(number);
    }

    public Number(double number) {
        this.value =number;
    }


    Number plus(Number number){
       return new Number(this.value + number.value);
    }

    Number minus(Number number){
        return new Number(this.value - number.value);
    }

    Number multiple(Number number){
        return new Number(this.value * number.value);
    }

    Number divide(Number number){
        return new Number(this.value / number.value);
    }

    double doubleValue(){
        return value;
    }
}
