package telran.multithreading;

import java.util.Arrays;

import telran.view.*;

public class Main {
    static InputOutput io = new StandardInputOutput();

    final static int MIN_SLEEP = 1;
    final static int MAX_SLEEP = 100;
    final static int DISTANCE_MIN = 10;
    final static int DISTANCE_MAX = 100;
    final static int NUMBERS_MIN = 10;
    final static int NUMBERS_MAX = 100;


    public static void main(String[] args) {
        racersDataComplition();
    }

    private static void racersDataComplition() {
        int maxSleep;
        int minSleep = io.readNumberRange("Enter minimum sleep in ms between " + MIN_SLEEP + " and " + MAX_SLEEP + ":",
                "Invalid sleep time, try again", MIN_SLEEP, MAX_SLEEP).intValue();

        if (minSleep != MAX_SLEEP) {
            maxSleep = io.readNumberRange("Enter max sleep in ms between " + minSleep + " and " + MAX_SLEEP + ":",
                    "Invalid sleep time, try again", minSleep, MAX_SLEEP).intValue();
        } else {
            maxSleep = minSleep;
        }

        int distance = io.readNumberRange("Enter distance between " + DISTANCE_MIN + " and " + DISTANCE_MAX + ":",
                "Invalid sleep time, try again", DISTANCE_MIN, DISTANCE_MAX).intValue();

        int numbers = io.readNumberRange("Enter number of racers between " + NUMBERS_MIN + " and " + NUMBERS_MAX + ":",
                "Invalid sleep time, try again", NUMBERS_MIN, NUMBERS_MAX).intValue();

        Race race = new Race(distance, minSleep, maxSleep);
        Racer[] racers = new Racer[numbers];

        raceStart(race, racers);
        raceFinish(racers);

        System.out.println("The winner of the race is racer number " + Racer.getWinner());

    }

    private static void raceFinish(Racer[] racers) {
        Arrays.stream(racers).forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {

            }
        });
    }

    private static void raceStart(Race race, Racer[] racers) {
        for (int i = 0; i < racers.length; i++) {
            racers[i] = new Racer(race, i + 1);
            racers[i].start();
        }

    }

}