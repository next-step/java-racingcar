package stringCalculator;

public class Symbol {
    String state;

    public Symbol(String state) {
        this.state = state;
    }

    public boolean isSameSymbol(String state){
       return this.state.equals(state);
    }

}
