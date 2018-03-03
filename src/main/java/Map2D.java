import java.util.Random;

public class Map2D {
    Integer width, height, maxTunnels, maxLength;
    Integer[][] map;
    Location position;

    public Map2D (Integer w,Integer h) {
        width = w;
        height = h;
        maxTunnels = 3;
        maxLength = 3;
        position = new Location(width, height);
    }

    private void createArray() {
        map = new Integer[height][width];
        for (int i = 0; i < height; i++ ) {
            for (int j = 0; j < width; j++) {
                map[i][j] = 1;
            }
        }
    }

    private void print() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("["+map[i][j]+"]");
            }
            System.out.println();
        }
    }

    public void random() {
        position.getRandomDirection();
    }

    public static void main(String[] args) {
        Map2D map = new Map2D(5, 5);
        map.createArray();
        map.print();
        map.random();

    }


}
