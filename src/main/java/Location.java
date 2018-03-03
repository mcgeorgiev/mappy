import java.util.Random;
import java.util.Stack;

public class Location {

    private Integer x, y;
    private Stack<Direction> recentDirections;

    public Location(Integer mx, Integer mh) {
        setRandom(mx, mh);
    }

    public void move() {
        // move a random direction if not same or opposite

        // add new direction
        // set new x, y
    }

    public Direction getRandomDirection() {
        Direction[] directions = Direction.values();
        for (Direction d: directions) {
            System.out.println(d);
        }
        return null;
    }

    private void setRandom(Integer maxWidth, Integer maxHeight) {
        Random rand = new Random();
        Integer startX = rand.nextInt(maxWidth);
        Integer startY = rand.nextInt(maxHeight);
    }
}
