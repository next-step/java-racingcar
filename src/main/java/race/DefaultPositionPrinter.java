package race;

public class DefaultPositionPrinter implements PositionPrinter {
    @Override
    public void printPosition(int carNumber, int position) {
        System.out.println("-".repeat(position));
    }
}
