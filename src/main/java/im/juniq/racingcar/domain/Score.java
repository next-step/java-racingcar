package im.juniq.racingcar.domain;

public class Score {
		private String name;
		private int position;

		public Score(String name, int position) {
			this.name = name;
			this.position = position;
		}

		public String name() {
			return name;
		}

		public int position() {
			return position;
		}
	}