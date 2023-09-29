package com.hash.dictionaryadt;

/**    REFLECTION
 * What Size Array did you choose for your hashmap implementation?
 * My HashMap function can take in a capacity argument but the default constructor will
 * create an array of 100 Nodes. For this reflection however i am using an array size of 10,000
 *
 * How many collisions did your import produce?
 * With 10,000 items and 10,000 spots to fill my hash function created 8264 collisions.
 *
 * What are the reasons for the number of collisions?
 * There are 2 main reasons for this number of collisions. 1 is the hash function is just not that good.
 * The ascii value trick will very easily create collisions even with words that are not even remotely alike.
 * The second reason is there is no method to avoid collisions like making an array of linked lists to search
 * for your value at a collision.
 *
 * How could the hash function be improved to reduce collisions?
 * The Hash Function could be improved by creating a linked list at each hashed index instead of an individual
 * key and value paired node. This is because instead of throwing away the collision we can just add it to that
 * linked list and search through it when we need that specific key.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class WorldCitiesCSVDriver {

    public static Scanner scanObj = new Scanner(System.in);


    public static int size = 10000;

    public static Map<String, WorldCities> myHashMap = new Map<>();

    public static void main(String[] args) {

        System.out.println("Importing worldcities.csv file...");

        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("src/worldcities.csv"));

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from the second line
            int entries = 10000;
            while ((line = br.readLine()) != null && entries !=0)
            {
                entries--;
                String[] worldCitiesDetails = line.split(",");

                if(worldCitiesDetails.length > 0 )
                {
                    WorldCities worldcities = new WorldCities(worldCitiesDetails);
                    myHashMap.put(worldCitiesDetails[0].replaceAll("^\"|\"$", "" ), worldcities);
                }
            }
            System.out.print("Collisions: " + myHashMap.getCollisions() + "\n");

            Menu();

        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occured while closing the BufferedReader");
                ie.printStackTrace();
            }
        }

    }

    public static void Menu(){

        System.out.print("Enter a key\n");
        String key;
        key = scanObj.nextLine();



        if (key == "stop"){
            System.exit(2);
        }else {
            System.out.println(myHashMap.get(key));
            Menu();
        }
    }


}
