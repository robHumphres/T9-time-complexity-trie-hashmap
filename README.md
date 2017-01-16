# T9-time-complexity-trie-hashmap
Trie HashMap on a dictionary "T9" Analysis nanosecond times

For this project I took the T9 computations that were done on the old phones and did a time complexity between a Trie, and Hash. The way I was doing this was reading in a dictionary of 25k+ words from a text file. The permutations were done when a user would enter in a set of numbers say "111" this would give 3! 3! 3! because of abc. Now the Trie and Hash table would do their searching giving the following results to the screen after searching the dictionary that was organized by the trie and hash table. 
Results of "111": 
----------------------------------------------------------------
Words: aac abb abc aca acc bbc cab. 
Time Complexity of Trie: 219529 in nanoseconds
Time Complexity of Hashtable: 41760 in nanoseconds
Time Complexity of Combinations: 28351 in nanoseconds
Time Complexity of Program: 289640 in nanoseconds
----------------------------------------------------------------------

Info on both algorithms:
Trie: https://en.wikipedia.org/wiki/Trie
Hash: https://en.wikipedia.org/wiki/Hash_table

I noticed this this the hash was faster on smaller words, but they they started getting bigger, the trie was pretty comparable.
