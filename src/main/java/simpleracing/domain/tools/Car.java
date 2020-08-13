package simpleracing.domain.tools;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import simpleracing.domain.rule.Moving;

@Getter
@RequiredArgsConstructor
public class Car {
	@NonNull
	private String name;
	private int location;

	public Record play(Moving moving) {
		this.move(moving);

		return Record.builder()
					 .carName(name)
					 .location(location)
					 .build();
	}

	private void move(Moving moving) {
		if (moving.isPossible()) {
			this.advance();
		}
	}

	private void advance() {
		location++;
	}
}
