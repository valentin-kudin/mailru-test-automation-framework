package core.util.random;

import java.util.Random;

public class RandomOperations {

    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt((max - min) + 1) + min;
        return randomNumber;
    }
}
