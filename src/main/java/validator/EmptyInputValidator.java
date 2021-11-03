package validator;

public class EmptyInputValidator implements IValidator {
    @Override
    public void check(String input) {
        if(input == null) throw new IllegalArgumentException("input is null");
        if(input.trim().isEmpty()) throw new IllegalArgumentException("input is empty or blank");
    }
}