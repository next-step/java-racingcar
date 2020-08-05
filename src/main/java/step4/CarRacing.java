package step4;

import step4.dto.ParticipationForm;
import step4.collections.RaceResult;
import step4.ui.Announcer;
import step4.ui.Reception;

public class CarRacing {

    public static void main(String[] args) {
        ParticipationForm participationForm = Reception.takeParticipationForm();
        ControlTower controlTower = new ControlTower(participationForm);
        RaceResult raceResult = controlTower.startCarRacing();
        Announcer.announceResultPerLap(raceResult);
        Announcer.announceFinalResult(raceResult);
    }
}
