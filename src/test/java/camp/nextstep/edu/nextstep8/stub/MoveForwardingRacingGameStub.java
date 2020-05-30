package camp.nextstep.edu.nextstep8.stub;

import camp.nextstep.edu.nextstep8.racing.RacingCar;
import camp.nextstep.edu.nextstep8.racing.RacingGame;

import java.util.ArrayList;
import java.util.List;

public class MoveForwardingRacingGameStub extends RacingGame {
    public MoveForwardingRacingGameStub(int carNumbers, int raceTimes) {
        super(carNumbers, raceTimes);
    }

    @Override
    public List<RacingCar> generateRandomRuleEntryList(int carNumbers) {
        List<RacingCar> entryList = new ArrayList<>();
        for (int i = 0; i < carNumbers; i++){
            entryList.add(new RacingCar(new MoveForwardingRuleStub()));
        }
        return entryList;
    }
}
