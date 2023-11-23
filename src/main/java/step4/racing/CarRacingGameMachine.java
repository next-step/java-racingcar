package step4.racing;

import step4.racing.inout.InPutView;
import step4.racing.inout.OutPutView;

public class CarRacingGameMachine {

    public static void main(String[] args) {

        String names = InPutView.name();
        int howManyTimesToTry = InPutView.howManyTimesToTry();

        Cars cars = Cars.of(names);
        Referee referee = new AdvanceprobabilitySixtyPercentReferee();
        CarRacing carRacing = CarRacing.defaultOf(cars, howManyTimesToTry, referee);

        OutPutView outPutView = new OutPutView();
        carRacing.start(outPutView);
    }
}
