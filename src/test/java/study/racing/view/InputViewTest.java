package study.racing.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racing.domain.RaceInput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

   private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
   private final PrintStream originalOut = System.out;

   @BeforeEach
   void setUpStreams() {
      System.setOut(new PrintStream(outputStream));
   }

   @AfterEach
   void restoreStreams() {
      System.setOut(originalOut);
   }

   @Test
   @DisplayName("유효한 입력으로 RaceInput 객체를 생성할 수 있다")
   void createRaceInputWithValidInput() {
      String input = "5\n10\n";
      InputView inputView = new InputView(new ByteArrayInputStream(input.getBytes()));

      RaceInput raceInput = inputView.race();

      assertThat(raceInput.getNumberOfCars()).isEqualTo(5);
      assertThat(raceInput.getNumberOfAttempt()).isEqualTo(10);
   }

   @Test
   @DisplayName("두 입력 모두 잘못되면 재입력 후 RaceInput을 생성한다")
   void createRaceInputAfterBothInvalidInputs() {
      String input = "0\n3\nabc\n5\n";
      InputView inputView = new InputView(new ByteArrayInputStream(input.getBytes()));

      RaceInput raceInput = inputView.race();

      assertThat(raceInput.getNumberOfCars()).isEqualTo(3);
      assertThat(raceInput.getNumberOfAttempt()).isEqualTo(5);
   }

   @Test
   @DisplayName("두 번째 입력이 잘못되면 재입력 후 RaceInput을 생성한다")
   void createRaceInputAfterInvalidSecondInput() {
      String input = "3\n0\n5\n";
      InputView inputView = new InputView(new ByteArrayInputStream(input.getBytes()));

      RaceInput raceInput = inputView.race();
      assertThat(raceInput.getNumberOfCars()).isEqualTo(3);
      assertThat(raceInput.getNumberOfAttempt()).isEqualTo(5);
   }






}