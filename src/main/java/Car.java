import java.util.stream.IntStream;

public class Car {
    private final DiceRoller diceRoller;
    private final String name;
    private int length;

    public Car(DiceRoller diceRoller, String name) {
        this.diceRoller = diceRoller;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void printLength() {
        System.out.print(name + " : ");
        IntStream.range(0, length).forEach(e -> System.out.print("-"));
    }
}
