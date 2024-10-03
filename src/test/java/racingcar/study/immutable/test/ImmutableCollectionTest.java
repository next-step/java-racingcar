package racingcar.study.immutable.test;

import org.junit.jupiter.api.Test;
import racingcar.study.immutable.example.Age;
import racingcar.study.immutable.example.Animal;
import racingcar.study.immutable.example.ListObject;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ImmutableCollectionTest {

    @Test
    void immutable() {
        List<Animal> animals = new ArrayList<>(List.of(new Animal(new Age(1))));
        ListObject listObject = new ListObject(animals);
        for (Animal animal : listObject.getAnimals()) {
            System.out.println("prev = " + animal);
        }
        assertThatThrownBy(() -> {
            listObject.getAnimals().remove(0);
            listObject.getAnimals().add(0, new Animal(new Age(2)));
            for (Animal animal : listObject.getAnimals()) {
                System.out.println("after = " + animal);
            }
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}


