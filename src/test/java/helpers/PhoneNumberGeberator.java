package helpers;

import java.util.Random;

public class PhoneNumberGeberator {
//    public static  void main (String[]args){
//        System.out.println("phone:"+generatePhoneNumber());
//    }
    private static final int min_length = 10;
    private static final int max_lenght = 15;

    public static String generatePhoneNumber() {
        Random random = new Random();
        int lenght = random.nextInt(max_lenght - min_length - 1) + min_length;
        StringBuilder phoneNumber = new StringBuilder();
        for (int i = 0; i < lenght; i++) {
            if (i == 0) {
                phoneNumber.append(random.nextInt(7) + 2);
            } else {
                phoneNumber.append(random.nextInt(10));
            }
        }
        return phoneNumber.toString();
    }
}
