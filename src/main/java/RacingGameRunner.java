import racing.Stage;
import racing.car.ThresholdEngineCar;
import racing.player.RandomAcceleratePlayer;
import racing.watcher.DashTrackingWatcher;
import racing.watcher.RacingWatcher;

import java.util.Scanner;

public class RacingGameRunner {

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("레이싱에 참여 할 수 있는 자동차는 몇 대 인가요?");
		int entrySize = scanner.nextInt();

		System.out.println("시도할 회수는 몇 회 인가요?");
		int round = scanner.nextInt();

		// 게임 스테이지빌더 생성
		Stage.StageBuilder builder = Stage.builder(entrySize, round);

		// 플레이어 추가
		for(int i = 0; i < entrySize; i++) {
			builder.addToEntry(new RandomAcceleratePlayer(new ThresholdEngineCar()));
		}

		// 출력개체 설정
		RacingWatcher watcher = new DashTrackingWatcher((message -> System.out.println(message)));
		builder.watcher(watcher);

		// 스테이지 생성
		Stage stage = builder.build();

		// Play!
		while(stage.getRemainingRounds() > 0){
			stage.playRound();
		}

	}
}
