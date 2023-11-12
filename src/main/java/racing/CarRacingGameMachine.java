package racing;

import racing.inout.InPutView;
import racing.inout.OutPutView;

public class CarRacingGameMachine {

    public static void main(String[] args) {

        String names = InPutView.name();
        int howManyTimesToTry = InPutView.howManyTimesToTry();

        CarFactory carFactory = new CarFactory();
        ParticipationCars participationCars = carFactory.settingRacingCars(names);

        Referee referee = new AdvanceprobabilitySixtyPercentReferee();
        CarRacing carRacing = CarRacing.defaultOf(participationCars, howManyTimesToTry, referee);
        OutPutView outPutView = new OutPutView();
        carRacing.start(outPutView);
    }
}
