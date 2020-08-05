import java.util.stream.IntStream;

public class Car {
    private final DiceRoller diceRoller;
    int length;

    public Car(DiceRoller diceRoller) {
        this.diceRoller = diceRoller;
        this.length = 1;
    }

    public void go() {
        if (diceRoller.goeThan4()) {
            length++;
        }
    }

    public int getLength() {
        return length;
    }

    public void printLength() {
        IntStream.range(0, length).forEach(e -> System.out.print("-"));
    }
}
