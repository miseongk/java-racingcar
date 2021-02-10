package racingcargame.domain;

public class Car {
    private static final int THRESHOLD = 4;
    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;

    private String name;
    private int distance = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() < MINIMUM_LENGTH || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("길이가 1에서 5사이의 이름을 입력해주세요.");
        }
    }

    public void move(int number) {
        if (number >= THRESHOLD) {
            distance++;
        }
    }

    public boolean isWinner(int max) {
        return distance == max;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}