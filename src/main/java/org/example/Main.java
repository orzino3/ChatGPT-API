package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApiManager apiManager = new ApiManager();
        Scanner scanner = new Scanner(System.in);

        while(true){
            apiManager.setSendMessege(scanner.nextLine());
        }

    }

}