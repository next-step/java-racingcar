package step3.domain;

public class Car {

    private static final int compareRandomValue = 4;
    private int advance = 0;

    public int move(int randomValue) {
       return randomValue >= compareRandomValue ? ++this.advance : this.advance;
    }

    public int getAdvance() {
        return this.advance;
    }
}
