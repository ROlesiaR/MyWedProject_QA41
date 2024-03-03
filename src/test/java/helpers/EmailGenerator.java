package helpers;

import java.sql.SQLOutput;

public class EmailGenerator {
    public static void main(String[] args) {
        System.out.println("email: "+generateEmail(10,6,3));
    }
    public static String generateEmail(int a,int b,int c){
        if (a<=0||b<=0||c<=0){
            throw new IllegalArgumentException("Error in format email");
        }
        StringBuilder email = new StringBuilder();
        //mail@
        for (int i=0;i<a;i++){
            email.append(randomChar());
        }
        email.append("@");
        for (int i=0;i<b;i++){
            email.append(randomChar());
        }
        email.append(".");
        for (int i=0;i<c;i++){
            email.append(randomChar());
        }
        return email.toString();

    }
    private static char  randomChar(){
        return (char)('a'+Math.random()*('z'-'a'));
    }
}
