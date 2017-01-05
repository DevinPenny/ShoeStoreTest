/**
 * Created by Devin Penny on 1/4/17.
 */
package TestDataManagement;

import java.util.Random;

public class RandomDataGenerator {

    //create a string of random characters that is of variable length
    public String GetRandomString(int intLength){

        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder(intLength);

        for (int i = 0; i < 5; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));
        }

       //return random string value
        return randomString.toString();
    }

}