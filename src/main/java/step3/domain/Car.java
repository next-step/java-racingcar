package step3.domain;

public class Car {

    public static final int DEFAULT_POSITION = 1;
    public static final int MAXIMUM_NAME_LENGTH = 5;
    private static final String NAME_REGEX = "^[a-zA-Z0-9]*$";
    private int position;
    private String name;

    public Car(String name) throws IllegalArgumentException {
        validate(name);
        this.name = name;
        position = DEFAULT_POSITION;
    }

    private void validate(String name) throws IllegalArgumentException {
        if (!name.matches(NAME_REGEX)) {
            throw new IllegalArgumentException("차 이름은 알파벳 또는 숫자로만 이루어집니다");
        }

        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("차 이름 길이가 5 초과 불가");
        }
    }

    public int getPosition() {
        return position;
    }

    public void proceed() {
        ++position;
    }

    public void proceedWithPolicy(ProceedPolicy proceedPolicy) {
        if (proceedPolicy.canMoveForward(this)) {
            proceed();
        }
    }

    public String getName() {
        return this.name;
    }
}
