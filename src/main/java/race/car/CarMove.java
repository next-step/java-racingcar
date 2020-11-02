package race.car;

import java.util.Random;

public enum CarMove {


    MOVE {
        @Override
        public void carMove(int[] tryMoveCount) {
            for (int i = 0; i < tryMoveCount.length; i++) {
                tryMoveCount[i] = tryMoveCount[i] + addMoveCheck();
            }
        }

        private int addMoveCheck() {
            Random random = new Random();
            int num = random.nextInt(10);
            int returnValue = 0;

            if (num >= 4) {
                return 1;
            }

            return returnValue;
        }
    };


    abstract void carMove(int[] inputValue);
}
