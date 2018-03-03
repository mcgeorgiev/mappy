import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Location {

    private Integer x, y;
    public LinkedList<Direction> recentDirections;
    private int[] perpendicularVector = {-1, 1};
    private Direction[] directions;

    public Location(Integer mx, Integer mh) {
        directions = Direction.values();
        recentDirections = new LinkedList<Direction>();
        setStartLocation(mx, mh);
        setStartDirection();
    }

    public void move() {
        // get
        
        // ensure not off edge

        // add new direction

        // set new x, y
    }

    private void setStartDirection() {
        recentDirections.add(directions[new Random().nextInt(directions.length)]);
    }

    public Direction getRandomDirection() {
        //perpendicular is left and right of the direction
        int currentIndex = Arrays.asList(directions).indexOf(recentDirections.getLast());
        int leftOrRight = perpendicularVector[new Random().nextInt(perpendicularVector.length)];
        int newIndex = ((leftOrRight + currentIndex) % directions.length);
        return directions[newIndex];
    }

    private void setStartLocation(Integer mx, Integer my) {
        x = new Random().nextInt(mx);
        y = new Random().nextInt(my);
    }

    public Integer X() {
        return x;
    }

    public Integer Y() {
        return y;
    }


}
