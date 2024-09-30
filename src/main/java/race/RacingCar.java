package race;

public class RacingCar {

    private int position = 0;
    private String name;
    private static final int MOVE_CONDITION_NUMBER = 4;
    private NumberPicker numberPicker;

    public RacingCar(String name, NumberPicker numberPicker) {
        this.name = name;
        this.numberPicker = numberPicker;
    }

    public RacingCar(String name) {
        this.name = name;
        this.numberPicker = new NumberPicker();
    }

    public String getName() {
        return this.name;
    }

    public void moveForward() {
        if (isMovable(numberPicker.generateRandomNumberUnderTen())) {
            this.position++;
        }
    }

    public int getPosition() {
        return this.position;
    }

    private boolean isMovable(int number) {
        return number >= MOVE_CONDITION_NUMBER;
    }
}