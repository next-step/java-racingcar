package racingcar.manager;

public final class SecurityManager {
	public static void checkExit(final int status) {
		if (status != 2) {
			throw new SecurityException();
		}
		System.out.println("시스템 종료");
	}
}
