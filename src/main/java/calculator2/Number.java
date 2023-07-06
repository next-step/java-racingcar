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
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException("입력값이 잘못 되었습니다.");
        }
    }

}
