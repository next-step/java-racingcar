package carracing;

import carracing.dto.CarRaceResponse;
import carracing.dto.CarsResponse;
import carracing.ui.InputView;
import carracing.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRaceApplication {
    public static void main(String[] args) {
        InputView inputView = InputView.input();
        Track track = inputView.toTrack();

        List<CarsResponse> carsResponses = new ArrayList<>();
        for (int i = 0; i < inputView.getMovingCount(); i++) {
            track.run();
            carsResponses.add(CarsResponse.from(track.carHistory()));
        }

        OutputView.output(new CarRaceResponse(carsResponses));
    }
}
