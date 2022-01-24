package racing.domain;

public class Car {

    private final static int STANDARD_NUMBER_MOVE_FORWARD = 4;
    private final static int RANGE_OF_RANDOM_NUMBER = 10;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String checkSamePosition(int position) {
        if (this.position == position) {
            return name + ", ";
        }
        return "";
    }

    public void drive() {
        int randomNumber = generateRandomNumber();
        if (isMove(randomNumber)) {
            this.position++;
        }
        printStatus();
    }

    private boolean isMove(int randomNumber) {
        return randomNumber >= STANDARD_NUMBER_MOVE_FORWARD;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * RANGE_OF_RANDOM_NUMBER);
    }

    private void printStatus() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
