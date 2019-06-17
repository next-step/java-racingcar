package racing.watcher.events;

public class StartedRacingEvent implements RacingEvent {

	public static final String DEFAULT_START_MESSAGE = "실행 결과";

	public String getMessage(){
		return DEFAULT_START_MESSAGE;
	}
}
