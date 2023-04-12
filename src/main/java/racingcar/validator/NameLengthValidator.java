package racingcar.validator;

public class NameLengthValidator implements Validator<String> {
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void verify(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Car name cannot be null or empty");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            String message = String.format("Car name cannot exceed %s character: %s", MAX_NAME_LENGTH, name);
            throw new IllegalArgumentException(message);
        }
    }
}
