package step3;

public class CarRacing {

    public static void main(String[] args) {
        ControlTower controlTower = new ControlTower();
        ParticipationForm participationForm = Reception.takeParticipationForm();
        RaceResult raceResult = controlTower.startCarRacing(participationForm);
        Announcer.announceRaceResult(raceResult);
    }
}
