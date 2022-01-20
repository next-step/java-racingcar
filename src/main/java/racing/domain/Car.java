package racing.domain;

public class Car {
    private final static int MIN_MOVE_NUM = 4;
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private boolean isMove(int randomNumber) {
        return randomNumber >= MIN_MOVE_NUM;
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 9);
    }

    private void printStatus() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
