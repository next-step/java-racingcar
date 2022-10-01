package step3.position;

import step3.output.BarOutputView;
import step3.output.OutputView;

import java.util.Objects;

public final class CarPosition implements Position {

    private static final int DISTANCE = 1;

    private final int position;

    private final OutputView outputView;

    public CarPosition(int position) {
        this(position, new BarOutputView());
    }

    public CarPosition(int position, OutputView outputView) {
        this.position = position;
        this.outputView = outputView;
    }

    @Override
    public Position movedPosition() {
        return new CarPosition(position + DISTANCE, outputView);
    }

    @Override
    public void printPosition() {
        outputView.print(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position && Objects.equals(outputView, that.outputView);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, outputView);
    }

}
