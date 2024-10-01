package racingcar.util;

import racingcar.model.wrapper.ForwardStatus;

@FunctionalInterface
public interface NumberCreator {
    ForwardStatus number();
}
