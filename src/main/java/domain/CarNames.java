package domain;

public class CarNames {
    private static final String EMPTY_ERROR_MESSAGE = "error : 차 이름은 공백 을 입력할수 없습니다.";
    private static final String NULL_ERROR_MESSAGE = "error : 차 이름은 NULL 을 입력할수 없습니다.";
    private static final String COMMA = ",";
    private final String[] names;

    public CarNames(String names) {
        checkNull(names);
        checkEmpty(names);
        this.names = ofStringArray(names);
    }

    private void checkNull(String car) {
        if (car == null) {
            throw new IllegalArgumentException(NULL_ERROR_MESSAGE);
        }
    }

    private void checkEmpty(String car) {
        if (car.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
        }
    }

    private String[] ofStringArray(String names) {
        return names.split(COMMA);
    }

    public int count() {
        return names.length;
    }

    public String name(int index) {
        return names[index];
    }
}
