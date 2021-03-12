package step4;

public class Car {

    private int advance = 0;
    private String name;

    public Car() {}

    public Car(String name) {
        this.name = name;
    }

    public int move(int randomValue) {
        if(randomValue >= 4) {
            advance++;
        }

        return advance;
    }

    public int getAdvance() {
        return advance;
    }

    public void setAdvance(int advance) {
        this.advance = advance;
    }

    public String getName() {
        return name;
    }
}
