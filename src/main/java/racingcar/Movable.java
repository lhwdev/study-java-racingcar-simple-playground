package racingcar;


/**
 * 움직일 수 있는 사물을 나타냅니다. 이러한 사물은 위치와 환경을 갖습니다.
 * <p>
 * 이렇게 움직이고 있는 사물은, 매 '회차'에 한번씩 앞으로 나아가는 시도를 할 수 있습니다.
 */
public class Movable {

    private final Position position = new Position();
    private final Environment environment;

    public Movable(Environment environment) {
        this.environment = environment;
    }


    public int getPosition() {
        return position.get();
    }

    public void tryAdvance() {
        Environment.MoveResult result = environment.tryAdvance();
        if (result == Environment.MoveResult.MOVE) {
            position.forward();
        }
    }
}
