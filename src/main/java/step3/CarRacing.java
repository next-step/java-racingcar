package step3;

import step3.collections.RaceResult;
import step3.dto.ParticipationForm;
import step3.ui.Announcer;
import step3.ui.Reception;

public class CarRacing {

    public static void main(String[] args) {
        ParticipationForm participationForm = Reception.takeParticipationForm();
        ControlTower controlTower = new ControlTower(participationForm);
        RaceResult raceResult = controlTower.startCarRacing();
        Announcer.announceRaceResult(raceResult);
    }
}
