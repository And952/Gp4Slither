package de.mat2095.my_slither;
import java.util.Random;

class Food {

    final int x, y;
    private final double size;
    private final double rsp;
    private final long spawnTime;
    private final int color;

    Food(int x, int y, double size, boolean fastSpawn) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.rsp = fastSpawn ? 4 : 1;
        Random rand = new Random();
        this.color = rand.nextInt(6);
        spawnTime = System.currentTimeMillis();
    }

    int getColor() { return color; }


    double getSize() {
        return size;
    }

    double getRadius() {
        double fillRate = rsp * (System.currentTimeMillis() - spawnTime) / 1200;
        if (fillRate >= 1) {
            return size;
        } else {
            return (1 - Math.cos(Math.PI * fillRate)) / 2 * size;
        }
    }
}
