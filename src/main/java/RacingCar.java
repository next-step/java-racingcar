import java.util.Scanner;

public class RacingCar {
    private int carCount;
    private int moveCount;
    private static final Scanner scanner = new Scanner(System.in);

   public void inputCarAndMoveCount() {
       System.out.println("자동차 대수는 몇 대 인가요?");
       this.carCount = scanner.nextInt();
       System.out.println(this.carCount);

       System.out.println("시도할 회수는 몇 회 인가요?");
       this.moveCount = scanner.nextInt();
       System.out.println(this.moveCount);
   }

    public int getCarCount() {
        return this.carCount;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void setCarCount(int carCount) {
       this.carCount = carCount;
    }

    public void setMoveCount(int moveCount) {
       this.moveCount = moveCount;
   }
}
