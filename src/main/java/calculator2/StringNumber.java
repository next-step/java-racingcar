package calculator2;

// 과연 이 객체가 필요할까? StringNumberSet 에서 다 처리할 수 있을 것 같은데...
public class StringNumber {
    private int number;

    private StringNumber(int number) {
        this.number = number;
    }

    public static StringNumber create(String text) {
        int num = Integer.parseInt(text);
        if(num < 0) {
            throw new IllegalArgumentException();
        }
        return new StringNumber(num);
    }

    public int getNumber() {
        return number;
    }
}
