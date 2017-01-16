import java.io.*;
import java.util.*;

import Trie.*;

/**
 * Created by for example john on 10/26/2016.
 */

public class Main {
    //Member Variables
    //Implement a HashTable
    //Implement a Trie
    private static Hashtable<Integer,ArrayList<String>> hashtable = new Hashtable<>();
    private static TrieTree trie = new TrieTree();
    private static TrieTree tempTree;
    private static long m_comboTime, m_TrieTime, m_hastTableTime;

    public static void main(String [] args){

        long start;
        long end;

        ReadDictionary();


        do{
            //Read user input

            ArrayList<String> combos = letterCombinations(guiMenu());
            start = System.nanoTime();
            for(String e : combos)
            {
                if(trie.searchForWord(e)){
                    System.out.println("This was found in the Trie " + e);

                }//end of if
            }//end of for loop
            end = System.nanoTime();
            m_TrieTime = end - start;

            //How this works is taking the word combo from combos and then grabbing that dictionary
            for(String e : combos)
                FindAComboHashTable(e,hashtable.get(e.charAt(0)-'a'));

            System.out.println("Time Complexity of Trie: " + (m_TrieTime) + " in nanoseconds");
            System.out.println("Time Complexity of Hashtable: " + (m_hastTableTime) + " in nanoseconds");
            System.out.println("Time Complexity of Combinations: " + (m_comboTime) + " in nanoseconds");
            System.out.println("Time Complexity of Program: " + (m_TrieTime + m_hastTableTime + m_comboTime) + " in nanoseconds");

        }while(true);

    }//end of main

    public static void FindAComboHashTable(String e ,ArrayList arrayFromHashTable){
        //local variables
        long start;

        start = System.nanoTime();
        for(int x = 0; x<arrayFromHashTable.size();x++){
            if(e.equals(arrayFromHashTable.get(x))){
                System.out.println("This word was found in HashTable " + e);
            }//end of if
        }//end of for loop

        m_hastTableTime = (System.nanoTime() - start);

    }//end of find combo method

    public static ArrayList ListRead(Scanner scan, int letter){
        //create local variables
        ArrayList tempList = new ArrayList<String>();
        String temp;
        //pull char for when to break
        int compareLetter = letter+1;

        //Ghetto rewind on scanner since new scanner will be pasted in every time
        while(!(scan.nextLine().charAt(0)==(letter)))
            scan.nextLine();

        //put words from txt into dictionary for each list
        while(scan.hasNextLine())
        {
            temp = scan.nextLine();
            int Compare = (int)temp.charAt(0);
            if(Compare == compareLetter)
                break;

            //Insert into prefix tree
            String [] tempLis = temp.split(",");
            trie.insertWordIntoTrie(tempLis[0]);
            tempList.add(tempLis[0]);
        }//end of while
        
        return tempList;
    }


    public static void ReadDictionary(){
        // Open the file
        ArrayList<String> list = new ArrayList<String>();
        try {
            Scanner scan;
            scan = new Scanner(new File("dictionary.txt"));


            //Read File Line By Line
            for(int i = 'a'; i < 123; i++) {
                hashtable.put( i - 'a', ListRead(scan, i ));
            }
            scan.close();
        }catch (Exception e){
            System.out.println("Failure reading Lines from ReadDictionary");
        }
        System.out.println("Dictionary read in");
//Close the input stream

    }//end of ReadDictionary


    public static String guiMenu(){
        Scanner scan = new Scanner(System.in);
        String userInput;
        do {
            System.out.println("Keys are as below\n" +
                    "2={abc}\n" +
                    "3={def}\n" +
                    "4={ghi}\n" +
                    "5={jkl}\n" +
                    "6={mno}\n" +
                    "7={pqrs}\n" +
                    "8={tuv}\n" +
                    "9={wxyz}");
            System.out.println("quit exits program");
            System.out.print("Enter Number --->");
            userInput = scan.nextLine();

            if(userInput.equals("quit")){
                System.out.println("GoodBye");
                System.exit(0);
            }

            if(userInput.contains("1")||userInput.contains("0")){
                userInput = "asd";
            }
        }while(!tryParseInteger(userInput));


        return userInput;
    }

    private static boolean tryParseInteger(String value){
        try {
            Integer.parseInt(value);
            return true;
        }catch(NumberFormatException e){
            return false;
        }//end of catch
    }//end of tryParseInteger

    //Helper Hashmap for letterCombinations
    static final HashMap<Character, String> map = new HashMap<Character, String>() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };


    public static ArrayList<String> letterCombinations(String digits) {
        //Local Variables
        long start;
        ArrayList<String> ReturnComboList = new ArrayList<String>();
        ArrayList<String> tempList = new ArrayList<String>();

        //Add Blank To Combo List for space
        ReturnComboList.add("");
        //Start complexity time
        start = System.nanoTime();

        //Combination of the 3 or 4 digits for all the combinations
        for (int x = 0; x < digits.length(); x++) {
            for (String string : ReturnComboList) {
                String letters = map.get(digits.charAt(x));
                for (int z = 0; z < letters.length(); z++)
                    tempList.add(string + letters.charAt(z));
            }//end of for oop

            ReturnComboList = tempList;
            tempList = new ArrayList<String>();
        }


        //End result time for combos
        m_comboTime = (System.nanoTime() - start);

        return ReturnComboList;
    }




}
