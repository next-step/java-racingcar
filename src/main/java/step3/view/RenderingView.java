package step3.view;

import step3.RaceGameContract;
import step3.model.RacingCars;

public class RenderingView implements RaceGameContract.View {


    @Override
    public void renderView(RacingCars cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.getParticipantCar(i).getCommands());
        }
        System.out.println("");
    }
}
