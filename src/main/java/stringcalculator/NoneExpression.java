package stringcalculator;

public class NoneExpression implements Expression {
    private int value;

    public NoneExpression(int value) {
        this.value = value;
    }

    public NoneExpression(String valueInString) {
        try{
            this.value =  Integer.parseInt(valueInString);
        }catch (Exception exception){
            throw new IllegalArgumentException();
        }

    }

    @Override
    public int calculate() {
        return value;
    }
}
