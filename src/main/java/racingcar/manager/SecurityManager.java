package racingcar.manager;

public class SecurityManager {
	public static void checkExit(int status) {
		if (status != 2) {
			throw new SecurityException();
		}
		System.out.println("시스템 종료");
	}
}