package race;

public class DefaultPositionFormatter implements PositionFormatter {
    @Override
    public String format(int carNumber, int position) {
        return "Car " + String.format("%02d", carNumber + 1) + " : " + "-".repeat(position);
    }
}
