package racingcar.domain.collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.model.Memento;

import static org.assertj.core.api.Assertions.assertThat;

class HistoryTest {

    @Test
    @DisplayName("add 를 하면 Memento 가 추가되어야 한다.")
    void add() {
        History history = new History();
        int emptyMementoListSize = history.getMementoList().size();
        Memento memento = new Memento();
        history.add(memento);
        int mementoListSize = history.getMementoList().size();

        Assertions.assertAll(
                () -> {
                    assertThat(emptyMementoListSize)
                            .isEqualTo(0);
                },
                () -> {
                    assertThat(mementoListSize)
                            .isEqualTo(1);
                }
        );


    }
}
