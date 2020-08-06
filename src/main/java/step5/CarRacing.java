package step5;

import step5.ControlTower;
import step5.dto.ParticipationForm;
import step5.collections.RaceResult;
import step5.ui.Announcer;
import step5.ui.Reception;

public class CarRacing {

    public static void main(String[] args) {
        ParticipationForm participationForm = Reception.takeParticipationForm();
        ControlTower controlTower = new ControlTower(participationForm);
        RaceResult raceResult = controlTower.startCarRacing();
        Announcer.announceResultPerLap(raceResult);
        Announcer.announceFinalResult(raceResult);
    }
}
