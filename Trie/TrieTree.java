package Trie;

import java.util.*;
/**
 * Created by for example john on 10/27/2016.
 */
public class TrieTree {

    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }//end of TrieTree


    public boolean searchForWord(String wordSearchingFor) {
        TrieNode trie = searchForCurNode(wordSearchingFor);

        //Found it
        if(trie != null && trie.isLeaf)
            return true;

            //Didn't find it
        else
            return false;
    }//end of search


    public void insertWordIntoTrie(String word) {
        //Inserting Local variables
        TrieNode temporary;
        HashMap<Character, TrieNode> childToInsert = root.child;

        for(int x=0; x<word.length(); x++){
            char character = word.charAt(x);

            //Check to see if the child contains the key
            if(childToInsert.containsKey(character)){
                temporary = childToInsert.get(character);
            }//end of if

            //If the child isn't in that key go to a new temp node of character
            else{
                temporary = new TrieNode(character);
                childToInsert.put(character, temporary);
            }//end of else

            //Child will now temps child
            childToInsert = temporary.child;

            //checks to see if length is correct and then returns true
            if(x==word.length()-1)
                temporary.isLeaf = true;
        }//end of for loop

    }//end of insert

    public TrieNode searchForCurNode(String s){
        Map<Character, TrieNode> child = root.child;
        TrieNode temp = null;

        for(int i=0; i<s.length(); i++){
            char character = s.charAt(i);

            if(child.containsKey(character)){
                temp = child.get(character);
                child = temp.child;
            }//end of if
            else{
                //If can't find a child return null meaning false;
                return null;
            }//end null

        }//end of for loop

        return temp;
    }//end of Searching Node



}//end of TrieTree



class TrieNode{

        char NodeCharacter;
        HashMap<Character, TrieNode> child = new HashMap<>();
        boolean isLeaf;



        public TrieNode(char character){
            this.NodeCharacter = character;
        }

    public TrieNode() {}
}
