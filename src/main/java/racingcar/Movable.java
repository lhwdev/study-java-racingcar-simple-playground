package racingcar;


public class Movable {

    private final Environment environment;
    private final Position position = new Position();

    public Movable(Environment environment) {
        this.environment = environment;
    }


    public int getPosition() {
        return position.get();
    }

    public void tryMove() {
        Environment.MoveResult result = environment.tryMove();
        if (result == Environment.MoveResult.MOVE) {
            position.forward();
        }
    }
}
