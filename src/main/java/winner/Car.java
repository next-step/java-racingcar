package winner;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-10-29 22:17
 */
public class Car {

    private static final int MINIMUM_FUEL = 4;
    private static final String POSITION_TEXT = "-";
    private final StringBuilder POSITION = new StringBuilder();
    private final String name;
    private int position;


    public Car(String name) {
        this.name = name;
    }

    public void move(int fuel) {
        if (isMove(fuel)) {
            position++;
            POSITION.append(POSITION_TEXT);
        }
    }

    public String showPosition() {
        return String.format("%s : %s", name, POSITION);
    }

    private boolean isMove(int fuel) {
        return fuel >= MINIMUM_FUEL;
    }


}
