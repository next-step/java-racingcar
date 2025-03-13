import java.util.List;

import view.*;

public class RacingCarApplication {

    public static void main(String[] args) {
        List<Element> elements = List.of(QuantityInput.create(), MaxPositionInput.create());
        CreateRacingView createRacingView = CreateRacingView.publish(elements);
        createRacingView.render();
        createRacingView.toViewData();
    }
}
