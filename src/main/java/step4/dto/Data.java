package step4.dto;

public class Data {
    private static final int NAME_LENGTH = 5;
    private static final int DEFAULT_COUNT = 5;
    private static final String SEPARATOR = ",";
    private final String names;
    private final int count;

    public Data(String names) {
        this(names, DEFAULT_COUNT);
    }

    public Data(String names, int count) {
        if (names == null || names.length() < 1) {
            throw new IllegalArgumentException("입력한 자동차 이름이 없습니다.");
        }

        checkNameLength(names);

        if (count < 1) {
            throw new IllegalArgumentException("입력한 숫자가 올바르지 않습니다.");
        }

        this.names = names;
        this.count = count;
    }

    private void checkNameLength(String inputName) {
        String[] names = spliteName(inputName);
        for (String name : names) {
            nameCheck(name);
        }
    }


    public String getNames() {
        return names;
    }

    public int getCount() {
        return count;
    }

    public String[] spliteName(String names) {
        return names.split(SEPARATOR);
    }

    private void nameCheck(String name) {
        if (name.length() > NAME_LENGTH) {
            String message = "자동차 이름이 {0}자 초과하였습니다.".replaceAll("\\{0\\}", String.valueOf(NAME_LENGTH));
            throw new IllegalArgumentException(message);
        }
    }

    public String[] spliteName() {
        return names.split(SEPARATOR);
    }
}
