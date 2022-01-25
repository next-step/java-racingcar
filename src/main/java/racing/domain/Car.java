package racing.domain;

public class Car {

    private final static int MIN_MOVE_NUM = 4;
    private final static String COMMA_DELIMITER = ", ";
    private final static String BLANK = "";
    private final static String PROGRESS_STRING = "-";

    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String checkWinner(int maxPosition) {
        if (position == maxPosition) {
            return name + COMMA_DELIMITER;
        }
        return BLANK;
    }

    public int drive(int randomNumber) {
        if (isMove(randomNumber)) {
            position++;
        }
        printStatus();

        return position;
    }

    private boolean isMove(int randomNumber) {
        return randomNumber >= MIN_MOVE_NUM;
    }

    private void printStatus() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print(PROGRESS_STRING);
        }
        System.out.println();
    }
}
