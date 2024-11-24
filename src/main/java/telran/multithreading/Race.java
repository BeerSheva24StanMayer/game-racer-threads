
package telran.multithreading;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Race {
	private int distance;
	private int minSleep;
	private int maxSleep;
    private List<Integer[]> finishOrder = new ArrayList<>();
    private LocalTime raceStartTime;


	public Race(int distance, int minSleep, int maxSleep) {
		this.distance = distance;
		this.minSleep = minSleep;
		this.maxSleep = maxSleep;
	}
	
    public static LocalTime getStartTime(LocalTime raceStartTime) {
        raceStartTime = LocalTime.now();
        return raceStartTime;
    }

	public int getDistance() {
		return distance;
	}
	public int getMinSleep() {
		return minSleep;
	}
	public int getMaxSleep() {
		return maxSleep;
	}
	
    public void setRaceStart (LocalTime raceStartTime) {
        this.raceStartTime = raceStartTime;
    }

    public void addRacer (int number) {
        long raceTime = Duration.between(raceStartTime, LocalTime.now()).toMillis();
        Integer[] racer = {number, (int) raceTime};
        finishOrder.add(racer);
    }

    public List<Integer[]> getFinishOrder () {
        return new ArrayList<>(finishOrder);
    }
}