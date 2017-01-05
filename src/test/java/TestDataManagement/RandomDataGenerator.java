/**
 * Created by Devin Penny on 1/4/17.
 */
package TestDataManagement;

import java.util.Random;

public class RandomDataGenerator {

    //create a string of random characters that is of variable length
    public RandomDataGenerator GetRandomString(int length){

        String characters = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        StringBuilder randomString = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }

        //return randomString.toString();
        return null;
    }

}