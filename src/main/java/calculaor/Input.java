package calculaor;

public class Input {
    private static final String SPLIT_VALUE= " ";

    // 빈값 (null 값 or " ") 판단하기
    public Boolean checkBlank(String blankValue) {
        if (blankValue == null || blankValue.equals(" ") || blankValue.equals("")) {
            return true;
        }
        return false;
    }

    //  input값 " "기준으로 split하기
    public String[] splitter(String input) {
        return input.split(SPLIT_VALUE);
    }

    // splitter 테스트할 때, 예외 처리
    public String[] isSplit(String testInput) {
        if (checkBlank(testInput)) {
            throw new IllegalArgumentException();
        }
        return splitter(testInput);
    }
}
