package telran.multithreading;

import java.util.concurrent.ThreadLocalRandom;

public class Race {
private final int distance;
private final int minSleepTime; 
private final int maxSleepTime;

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