package telran.multithreading;

import java.util.concurrent.atomic.AtomicReference;

public class Racer extends Thread{
    private Race race;
    private int number;
    private static AtomicReference<Racer> winner = new AtomicReference<>();
    

    public Racer(Race race, int number) {
        this.race = race;
        this.number = number;
    }

    public void run(){
        for (int lap = 1; lap < race.getDistance(); lap++) {
            try {
                Thread.sleep(race.getSleepTime());
            } catch (InterruptedException e) {
                
            }
            System.out.println("Racer " + number + " on the lap " + lap);
        }
        if (winner.compareAndSet(null, this)) {
            System.out.println("Racer " + number + " has finished the race first");
        }
        else {
            System.out.println("Racer " + number + " finished the race");
        }
    }
    
    public static int getWinner() {
        return winner.get().number;
    }
}