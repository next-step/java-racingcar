package study;

import study.race.CarRace;
import study.race.io.RaceInputView;
import study.race.io.RaceResultView;

public class StudyMain {
    
    public static void main(String[] args) {
        System.out.println("Hello Next-Step !");
        RaceInputView inputView = new RaceInputView();
        inputView.input();

        CarRace carRace = new CarRace(inputView.getCarNum(), inputView.getTryNum());
        carRace.run();

        RaceResultView resultView = new RaceResultView(carRace.getCars());
        System.out.println(resultView.getPrint());
    }

}
