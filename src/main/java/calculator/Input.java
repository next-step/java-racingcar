package calculator;

public class Input {
    private String input;

    public Input(String input) {
        this.input = input;
    }

    public boolean isEmptyOrNull(){
        if(this.input == null || this.input.isBlank()){
            return true;
        }
        return false;
    }

}
