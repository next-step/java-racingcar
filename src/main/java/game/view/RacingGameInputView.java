package game.view;

import game.domain.CarName;

import java.util.List;

public interface RacingGameInputView {
    public int getTime();

    public List<CarName> getCarNameList();
}
