package racingcar;

public class View {
    public Memento memento;

    public View(Memento memento) {
        this.memento = memento;
    }

    protected String convertCarPosition(int carPosition) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < carPosition; j++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public String toString() {
        int[] carPositions = memento.getCarPositions();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carPositions.length; i++) {
            sb.append(convertCarPosition(carPositions[i]));
            sb.append("\n");
        }
        return sb.toString();
    }
}
