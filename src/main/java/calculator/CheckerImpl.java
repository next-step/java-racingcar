package calculator;

public class CheckerImpl implements Checker {
    @Override
    public void checkBlank(String inputText) {
        if(inputText.isEmpty()){
            throw new IllegalArgumentException("You should not input blank.");
        }
    }

    @Override
    public void throwNotCorrectSign() {
        throw new IllegalArgumentException("You should only sign word.");
    }
}
