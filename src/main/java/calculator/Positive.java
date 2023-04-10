package calculator;

public class Positive {

    private final int number;

    public Positive(String text){
        this.number = Integer.parseInt(text);
        if (this.number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
    }

    public int getNumber(){
        return this.number;
    }
}
