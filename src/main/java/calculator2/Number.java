package calculator2;

public class Number {

    private final int num;

    Number(String string) {
        validateInt(string);
        this.num = Integer.parseInt(string);
    }

    public int getNum() {
        return num;
    }

    private void validateInt(String string) {
        try {
            int num = Integer.parseInt(string);
            if (num < 0) {
                throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
        }
    }

}
