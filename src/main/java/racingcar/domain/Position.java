package racingcar.domain;

import java.util.Objects;

public class Position {

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public void updatePosition() {
        position++;
    }

    public int compareAndFindPosition(int maxPosition) {
        return Math.max(this.position, maxPosition);
    }

    public boolean isSamePosition(int winnerPosition) {
        return winnerPosition == this.position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
