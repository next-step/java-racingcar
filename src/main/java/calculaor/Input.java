package calculaor;


public class Input {
    private final String splitValue = " ";

    // 빈값 (null 값 or " ") 판단하기
    public Boolean checkBlank(String blankValue) {
        if (blankValue.equals(" ") || blankValue == null) {
        }
        return true;
    }

    //  input값 " "기준으로 split하기
    public String[] isSplit(String input) {
        return input.split(splitValue);
    }

    // splitter 테스트할 때, 예외 처리
    public String[] splitException(String testInput) {
        if (checkBlank(testInput)) {
            throw new IllegalArgumentException();
        }
        return isSplit(testInput);
    }
}
