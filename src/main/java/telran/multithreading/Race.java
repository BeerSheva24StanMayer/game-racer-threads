package telran.multithreading;

import java.util.concurrent.ThreadLocalRandom;

public class Race {
private final int distance; // Number of iterations (steps) each racer needs to complete
private final int minSleepTime; // Minimum sleep time (in milliseconds) for a racer
private final int maxSleepTime; // Maximum sleep time (in milliseconds) for a racer

public Race(int distance, int minSleepTime, int maxSleepTime) {
    this.distance = distance;
    this.minSleepTime = minSleepTime;
    this.maxSleepTime = maxSleepTime;
}

public int getDistance () {
    return distance;
}

public int getSleepTime () {
    return ThreadLocalRandom.current().nextInt(minSleepTime, maxSleepTime + 1);
}


}