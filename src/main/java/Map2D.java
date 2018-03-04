import org.json.JSONArray;

import java.util.Arrays;
import java.util.Random;

public class Map2D {
    Integer width, height, maxTunnels, maxLength;
    Integer[][] map;
    Location position;

    public Map2D (Integer w,Integer h) {
        width = w;
        height = h;
        maxTunnels = 50;
        maxLength = 8;
        position = new Location(width, height);
        createArray();
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

    private void create() {

        while ((maxTunnels != 0)) {

            int tunnelLength = 0;
            int randomTunnelLength = getRandomTunnelLength();
//            System.out.println("Tunnel Length "+ randomTunnelLength);

            position.newDirection();
            System.out.println(position.recentDirections.getLast() + ": " + randomTunnelLength);
            while (tunnelLength < randomTunnelLength) {
               if (position.inBounds()) {
                   position.move();
                   map[position.Y()][position.X()] = 0;
                   tunnelLength++;
               } else {
                   break;
               }
            }

            maxTunnels --;

        }
    }

    private int getRandomTunnelLength() {
        return (new Random().nextInt(maxLength)+1);
    }

    public JSONArray getMap() {
        create();
        print();
        return new JSONArray(Arrays.asList(map));


    }


}
