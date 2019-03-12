package car.entity;

import java.util.List;

public class RacingRound {
   private List<Car> round;

   public static RacingRound getRacingRoundInstance(List<Car> aRound) {
      RacingRound round = new RacingRound();
      round.setRound(aRound);
      return round;
   }

   public void setRound(List<Car> aRound) {
      this.round = aRound;
   }

   public List<Car> getRound() {
       return round;
   }
}
