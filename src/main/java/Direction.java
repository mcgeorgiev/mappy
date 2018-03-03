public enum Direction {
    NORTH (0, -1),
    EAST  (1, 0),
    SOUTH (0, 1),
    WEST  (-1, 0);

    private final int xInc;
    private final int yInc;
    Direction(int x, int y) {
        xInc = x;
        yInc = y;
    }
    int X () {
        return xInc;
    }
    int Y() {
        return yInc;
    }

}
