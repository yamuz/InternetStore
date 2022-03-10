package utils;

import security.AuthenticationManager;


import java.util.Scanner;

public class Dummy {
    public static void main(String[] args) {

        String pass = (new Scanner(System.in)).nextLine();
        String encoded = AuthenticationManager.encode(pass);

        System.out.println("encoded.." + encoded);
        System.out.println("decoded.." + AuthenticationManager.decode(encoded));
    }
}
