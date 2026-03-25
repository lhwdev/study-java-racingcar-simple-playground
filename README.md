# 자동차 경주 애플리케이션

간단한 콘솔 애플리케이션을 구현합니다.

## 기능 명세서

### 자동차 [`Car`](src/main/java/racingcar/Car.java)

- 이름을 가지고 있다.
- 정수로 된 위치를 가지고 있다: [`Movable`](src/main/java/racingcar/Movable.java).[
  `position`](src/main/java/racingcar/Position.java)
- 자동차를 둘러싼 환경이 정의된다: [`Environment`](src/main/java/racingcar/Environment.java)
- 한번 움직이려고 할 때마다,
    * 6/10 확률로 장애물을 회피할 수 있다: [`ObstaclesAhead`](src/main/java/racingcar/ObstaclesAhead.java)
    * 장애물을 회피할 경우 1칸 전진한다. 그렇지 않다면 전진하지 않는다.
    * 너무 많이 전진하여, 위치가 `Integer.MAX_VALUE`에서 더 나아간다면 예외를 발생시킨다.

### 자동차 경주 [`CarRacing`](src/main/java/racingcar/CarRacing.java)

- n대의 자동차가 참여할 수 있다.
- 게임의 횟수를 입력받는다.
- 매 회차마다 모든 자동차들은 전진 또는 멈출 수 있다.
    * 전진을 하는지 여부는 위의 자동차에서 정의된 대로 한다.
- 경주 게임을 완료한 후, 누가 우승했는지를 구한다. 우승자는 한 명 이상일 수 있다.
