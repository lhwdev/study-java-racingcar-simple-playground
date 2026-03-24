package racingcar;

import java.util.Random;


public interface ObstaclesAhead {

    enum Result {AVOIDED, BLOCKED}


    Result tryAvoid();


    class ByRandom implements ObstaclesAhead {
        private final Random random;

        public ByRandom() {
            random = new Random();
        }

        public ByRandom(long seed) {
            random = new Random(seed);
        }


        @Override
        public Result tryAvoid() {
            int probability = random.nextInt(0, 10);
            if (probability >= 4) {
                return Result.AVOIDED;
            }
            return Result.BLOCKED;
        }
    }


    class Blocked implements ObstaclesAhead {
        @Override
        public Result tryAvoid() {
            return Result.BLOCKED;
        }
    }

    class NoObstacles implements ObstaclesAhead {
        @Override
        public Result tryAvoid() {
            return Result.AVOIDED;
        }
    }
}
