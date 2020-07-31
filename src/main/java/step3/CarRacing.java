package step3;

public class CarRacing {

    public static void main(String[] args) {
        ControlTower controlTower = new ControlTower();
        RaceResult raceResult = controlTower.startCarRacing(Reception.takeParticipationForm());
        System.out.println("최종 우승 자동차 번호 : '" + raceResult.getFinalWinnerCarNumber() + "'");
    }
}
