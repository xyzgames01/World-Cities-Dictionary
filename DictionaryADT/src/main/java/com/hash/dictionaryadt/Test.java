package com.hash.dictionaryadt;

public class Test {
    public static void main(String[] args){



        Map<String, Integer> myHashMap = new Map<>(10);
        myHashMap.put("Orange", 30);
        myHashMap.put("Apple", 20);
        myHashMap.put("pAple", 50);
        myHashMap.put("Blueberry", 10);



        System.out.println(myHashMap.get("Apple"));

        System.out.println(myHashMap.get("pAple"));

        System.out.println(myHashMap.size());
        System.out.println(myHashMap.getCollisions());

    }

}
