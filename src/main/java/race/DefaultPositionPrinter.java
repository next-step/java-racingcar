package race;

public class DefaultPositionPrinter implements PositionPrinter {
    @Override
    public void printPosition(String carName, int position) {
        System.out.println("-".repeat(position));
    }
}
