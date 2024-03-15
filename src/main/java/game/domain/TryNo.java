package game.domain;

public class TryNo {

    private final int number;

    public TryNo(int number) {
        validate(number);
        this.number = number;
    }

    private static void validate(int number) {
        if(number <=0){
            throw new RuntimeException();
        }
    }

    public int getNumber() {
        return number;
    }
}
