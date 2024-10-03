package racingcar.study.staticfactory.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.study.staticfactory.example.Character;

/**
 * 1.가독성이 좋다
 */
public class CharacterTest {
    @Test
    void create() {
        Assertions.assertThatNoException().isThrownBy(() -> {
            Character warrior = new Character(5, 15, 20, 3);
            Character mage = new Character(15, 5, 10, 15);
        });
    }
    @Test
    void createUsingStaticFactoryMethod() {
        Character warrior = new Character(5, 15, 20, 3);
        Character mage = new Character(15, 5, 10, 15);

        Character actualWarrior = Character.newWarrior();
        Character actualMage = Character.newMage();

        Assertions.assertThat(actualWarrior).isEqualTo(warrior);
        Assertions.assertThat(actualMage).isEqualTo(mage);
    }
}
