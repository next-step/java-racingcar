package racing.watcher;

import racing.watcher.events.RacingEvent;

import java.lang.reflect.Method;

public abstract class RacingWatcher {

	private static final String METHOD_NAME = "handle";

	public final void handle(RacingEvent event){

		Method method;
		try {
			method = this.getClass().getDeclaredMethod(METHOD_NAME, event.getClass());

			if (method != null) {
				method.setAccessible(true);
				method.invoke(this, event);
			}

		} catch (Exception e) {
			// do nothing
			// 게임 중계자가 발생시키는 오류는 무시
		}

	}
}
