package step3;

import step3.dto.ParticipationForm;
import step3.ui.Announcer;
import step3.ui.Reception;

public class CarRacing {

    public static void main(String[] args) {
        ControlTower controlTower = new ControlTower();
        ParticipationForm participationForm = Reception.takeParticipationForm();
        RaceResult raceResult = controlTower.startCarRacing(participationForm);
        Announcer.announceRaceResult(raceResult);
    }
}
