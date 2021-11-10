package step3.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class NamesTest {

    private static final String NAME_1 = "길동";
    private static final String NAME_2 = "미미";
    private static final String NAME_3 = "철수";

    @DisplayName("문자열로 NAME 리스트 만들기")
    @Test
    void listOfEqualsTest() {
        Names names = Names.from(NAME_1 + "," + NAME_2 + "," + NAME_3);

        Names expectedNames = new Names(asList(new Name(NAME_1), new Name(NAME_2), new Name(NAME_3)));
        assertThat(names).isEqualTo(expectedNames);
    }

    @DisplayName("Names로 Cars 생성 잘되는지")
    @Test
    void convertToCar() {
        //given
        Location location = Location.placeOn(Cars.DEFAULT_LOCATION);
        Names names = Names.from(NAME_1 + "," + NAME_2 + "," + NAME_3);

        //when
        Cars cars = names.convertToCar();

        //then
        Cars expectedCars = new Cars(asList(
                new Car(location, new Name(NAME_1)),
                new Car(location, new Name(NAME_1)),
                new Car(location, new Name(NAME_1)))
        );
        assertThat(cars).isEqualTo(expectedCars);
    }

}
