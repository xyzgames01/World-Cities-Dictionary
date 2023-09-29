package com.hash.dictionaryadt;

/**
 * Zachary Zawodny
 * ITN262
 * April 8th 2023
 * Dictionary ADT
 *
 * Credit to https://www.codingninjas.com/codestudio/library/implementation-of-hashmap for a great
 * explanation of creating a hashmap in java. I used there example to create a collision-less HashMap
 *
 * @param <K> key
 * @param <V> Value
 */

public class Map<K, V> {

    private class Node<K,V>{  // contains two parameters - key and value
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;  // initialising the key
            this.value = value;   // initialising the value
        }
    }

    private int size;
    private int capacity;
    private int collisions;
    Node[] bucket; // N = buckets.length

    public Map() {
        bucket = new Node[100];
        size = 0;
    }
    public Map(int cap) {
        this.capacity = cap;
        bucket = new Node[capacity];
        size = 0;
    }


    public void put(K key, V value)
    {
        int bi = hashfn(key);   // getting the value of index of bucket
        // inside the bucket
        if(bucket[bi] != null)
        {
            // if the key is already present add to collisions
            collisions++;
        }
        else
        {
            // if the key is not already present
            Node node = new Node(key,value);  // make a new node with that key-value
            bucket[bi] = node;  // add it on index bi
            size++;  // increase the size
        }
    }



    public V get(K key) {
        int bi = hashfn(key);    // index of the bucket

        //bucket
        if(bucket[bi] != null){ // if the key is present at di, return its value. Otherwise,
            // Return null

            return (V) bucket[bi].value;
        }
        else{
            return null;
        }
    }

    public int size() {
        return size;  // return the value of size variable
    }

    public int getCollisions(){
        return collisions; // return the amount of collisions
    }

    public int hashfn(K k) {
        String kString = k.toString();
        char ch[];
        ch = kString.toCharArray();
        int i, sum;
        for (sum=0, i=0; i<kString.length(); i++)
            sum += ch[i];
        return sum % bucket.length;
    }

}
