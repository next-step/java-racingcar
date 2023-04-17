package study;

import study.race.CarRace;
import study.race.condition.RaceConditionNumber;
import study.race.condition.impl.RaceRandomNumber;
import study.race.io.RaceInputView;
import study.race.io.RaceResultView;

public class StudyMain {
    
    public static void main(String[] args) {
        System.out.println("Hello Next-Step !");
        RaceInputView inputView = new RaceInputView();
        inputView.input();

        RaceConditionNumber conditionNumber = new RaceRandomNumber();
        CarRace carRace = new CarRace(conditionNumber);
        carRace.ready(inputView.getEntryNum(), inputView.getRaceNum());
        carRace.run();

        RaceResultView resultView = new RaceResultView(carRace.getRaceResult());
        System.out.println(resultView.getPrint());
    }

}
