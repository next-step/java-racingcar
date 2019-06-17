import racing.Stage;
import racing.car.ThresholdEngineCar;
import racing.player.RandomAcceleratePlayer;
import racing.watcher.DashTrackingBroadcaster;

import java.util.Scanner;

public class RacingGameRunner {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("레이싱에 참여 할 수 있는 자동차는 몇 대 인가요?");
		int entrySize = scanner.nextInt();

		System.out.println("시도할 회수는 몇 회 인가요?");
		int round = scanner.nextInt();

		Stage.StageBuilder builder = Stage.builder(entrySize, round);
		for(int i = 0; i < entrySize; i++) {
			builder.addToEntry(new RandomAcceleratePlayer(new ThresholdEngineCar()));
		}

		builder.watcher(new DashTrackingBroadcaster());
		Stage stage = builder.build();

		while(stage.getRemainingRounds() > 0){
			stage.playRound();
		}

	}
}
