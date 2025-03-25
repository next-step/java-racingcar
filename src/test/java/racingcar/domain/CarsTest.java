package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class CarsTest {
  Car mockCar1 = mock(Car.class);
  Car mockCar2 = mock(Car.class);
  Car mockCar3 = mock(Car.class);

  @BeforeEach
  void setUp() {
    when(mockCar1.getName()).thenReturn("pobi");
    when(mockCar2.getName()).thenReturn("crong");
    when(mockCar3.getName()).thenReturn("honux");
  }

  @Test
  @DisplayName("우승자가 한 명이면 한 명의 이름을 반환한다.")
  void getWinnerOne() {
    int maxPosition = 2;
    when(mockCar1.getPosition()).thenReturn(maxPosition);
    when(mockCar2.getPosition()).thenReturn(maxPosition-1);
    when(mockCar3.getPosition()).thenReturn(maxPosition-1);
    when(mockCar1.equalsPosition(maxPosition)).thenReturn(true);
    when(mockCar2.equalsPosition(maxPosition)).thenReturn(false);
    when(mockCar3.equalsPosition(maxPosition)).thenReturn(false);

    List<Car> carsList = new ArrayList<>();
    carsList.add(mockCar1);
    carsList.add(mockCar2);
    carsList.add(mockCar3);
    Cars cars = new Cars(carsList);

    assertThat(cars.getWinners()).containsExactly("pobi");
  }

  @Test
  @DisplayName("우승자가 여러 명이면 여러 명의 이름을 반환한다.")
  void getWinnerMultiple() {
    int maxPosition = 1;
    when(mockCar1.getPosition()).thenReturn(maxPosition);
    when(mockCar2.getPosition()).thenReturn(maxPosition);
    when(mockCar3.getPosition()).thenReturn(maxPosition);
    when(mockCar1.equalsPosition(maxPosition)).thenReturn(true);
    when(mockCar2.equalsPosition(maxPosition)).thenReturn(true);
    when(mockCar3.equalsPosition(maxPosition)).thenReturn(true);

    List<Car> carsList = new ArrayList<>();
    carsList.add(mockCar1);
    carsList.add(mockCar2);
    carsList.add(mockCar3);
    Cars cars = new Cars(carsList);

    assertThat(cars.getWinners()).containsExactlyInAnyOrder("pobi", "crong", "honux");
  }

}
