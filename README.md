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
- 
