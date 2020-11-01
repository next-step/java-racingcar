package step3;

import step3.model.RacingCars;

public interface RaceGameContract {

    interface View {
        void renderView(RacingCars cars);
    }

    interface Presenter {
        RacingCars createParticipantRacingCar(int participantCar);
        void orderCommand(int participant);
    }
}
