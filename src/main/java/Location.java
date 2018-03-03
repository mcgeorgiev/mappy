import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Location {

    private Integer x, y;
    public LinkedList<Direction> recentDirections;
    private int[] perpendicularVector = {-1, 1};
    private Direction[] directions;

    public Location(Integer mx, Integer mh) {
        setRandom(mx, mh);
        directions = Direction.values();
        recentDirections = new LinkedList<Direction>();
    }

    public void move() {
        // move a random direction if not same or opposite

        // add new direction
        // set new x, y
    }

    public void setStartDirection() {
        recentDirections.add(directions[new Random().nextInt(directions.length)]);
    }

    public Direction getRandomDirection() {
        //perpendicular is left and right of the direction
        int currentIndex = Arrays.asList(directions).indexOf(recentDirections.getLast());
        int leftOrRight = new Random().nextInt(perpendicularVector.length);
        int newIndex = (leftOrRight + currentIndex) % directions.length;
        return directions[newIndex];
    }



    private void setRandom(Integer maxWidth, Integer maxHeight) {
        Random rand = new Random();
        Integer startX = rand.nextInt(maxWidth);
        Integer startY = rand.nextInt(maxHeight);
    }
}
