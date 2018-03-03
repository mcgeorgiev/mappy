
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Location {

    private Integer x, y;
    public LinkedList<Direction> recentDirections;
    private int[] perpendicularVector = {-1, 1};
    private Direction[] directions;
    private Integer maxX, maxY;

    public Location(Integer mx, Integer my) {
        maxX = mx;
        maxY = my;

        directions = Direction.values();
        recentDirections = new LinkedList<Direction>();
        setStartLocation();
        setStartDirection();
    }

    public void move() {

        x += recentDirections.getLast().X();
        y += recentDirections.getLast().Y();
    }

    public boolean inBounds() {
        int potentialX = recentDirections.getLast().X() + x;
        int potentialY = recentDirections.getLast().Y() + y;

       return !((potentialX < 0) || (potentialX >= maxX ) || (potentialY < 0)  || (potentialY >= maxY));
    }

    private void setStartDirection() {
        recentDirections.add(directions[new Random().nextInt(directions.length)]);
    }

    public void newDirection() {
        recentDirections.add(getRandomDirection());
    }

    private Direction getRandomDirection() {
        //perpendicular is left and right of the direction
        int currentIndex = Arrays.asList(directions).indexOf(recentDirections.getLast());
        int leftOrRight = perpendicularVector[new Random().nextInt(perpendicularVector.length)];
        int newIndex = Math.floorMod((leftOrRight + currentIndex), directions.length);

//        System.out.println("Current: " + currentIndex + ", Move: " + leftOrRight + ", New: " + newIndex);
        return directions[newIndex];
    }

    private void setStartLocation() {
        x = new Random().nextInt(maxX);
        y = new Random().nextInt(maxY);
    }

    public Integer X() {
        return x;
    }

    public Integer Y() {
        return y;
    }


}
