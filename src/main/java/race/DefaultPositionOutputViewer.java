package race;

public class DefaultPositionOutputViewer implements PositionOutputViewer {
    @Override
    public void showPosition(int carNumber, int position) {
        System.out.println("Car " + String.format("%02d", carNumber + 1) + " : " + "-".repeat(position));
    }
}
