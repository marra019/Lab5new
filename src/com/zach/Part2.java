package com.zach;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
    public class Main {
        static Scanner numberScanner = new Scanner(System.in);
        public static void main(String[] args) throws IOException {
            int numberOfHouses = 8;
            int[] cratesPerHouse = getRecyclingPerHouse(numberOfHouses);
            int totalCrates = calculateTotal(cratesPerHouse);
            int maxCrates = calculateMax(cratesPerHouse);
            int minCrates = calculateMin(cratesPerHouse);
            ArrayList houseWithMostRecycling = calculateHouseWithMostRecycling(cratesPerHouse);
            System.out.println("Total crates from all houses = " + totalCrates);
            System.out.println("Max crates at any house = " + maxCrates);
            System.out.println("Min crates at any house = " + minCrates);
            System.out.println("House(s) with most recycling = " + houseWithMostRecycling);
            numberScanner.close();
            //new code starts here
            try {
                BufferedWriter bufWriter = new BufferedWriter(new FileWriter("HouseRecycle.txt"));
                for (int x = 0; x < cratesPerHouse.length; x++) {
                    bufWriter.write("House " + x + " recycled " + cratesPerHouse[x] + " crates.\n");
                }
                bufWriter.write("\n");
                bufWriter.write("Total crates recycled: " + totalCrates + "\n");
                bufWriter.write("\n");
                bufWriter.write("Houses that recycled the most\n");
                for (Object ob : houseWithMostRecycling) {
                    int x = (int) ob;
                    bufWriter.write("House " + x + ": " + cratesPerHouse[x] + " crates.\n");
                }
                bufWriter.close();

            } catch(IOException ioe){
                System.out.println("An IO exception was thrown.");
                ioe.printStackTrace();
            }
        }public static int[] getRecyclingPerHouse ( int houses){
            int[] crates = new int[houses];
            for (int x = 0; x < houses; x++) {
                System.out.println("Enter the number of crates for house " + x);
                crates[x] = numberScanner.nextInt();
            }return crates;
        }public static int calculateTotal(int[] cratesPerHouse) {
            int sum = 0;
            for (int crates : cratesPerHouse) {
                sum += crates;
            }return sum;
        }public static int calculateMax(int[] cratesPerHouse) {
            int max = 0;
            for (int crates : cratesPerHouse) {
                if (crates > max) {
                    max = crates;
                }
            }return max;
        }public static int calculateMin(int[] cratesPerHouse) {
            int min = cratesPerHouse[0];
            for (int crates : cratesPerHouse) {
                if (crates < min) {
                    min = crates;
                }
            }return min;
        }public static ArrayList calculateHouseWithMostRecycling(int[] cratesPerHouse) {
            ArrayList houses = new ArrayList();
            for (int x = 0; x < cratesPerHouse.length; x++) {
                if (cratesPerHouse[x] == calculateMax(cratesPerHouse)) {
                    houses.add(x);
                }
            }return houses;
        }
    }

}
