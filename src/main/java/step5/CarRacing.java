package step5;

import step5.domain.collections.RaceResult;
import step5.dto.ParticipationForm;
import step5.view.Announcer;
import step5.view.Reception;
import step5.view.input.InputChannel;
import step5.view.output.OutputChannel;

public class CarRacing {

    public static void main(String[] args) {
        Reception reception = new Reception(InputChannel.createSystemIn(), OutputChannel.createSystemOut());
        ParticipationForm participationForm = reception.takeParticipationForm();
        ControlTower controlTower = new ControlTower(participationForm);
        RaceResult raceResult = controlTower.startCarRacing();
        Announcer announcer = new Announcer(OutputChannel.createSystemOut());
        announcer.announceFinalResult(raceResult);
    }
}
