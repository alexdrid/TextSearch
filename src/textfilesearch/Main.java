/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfilesearch;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Alex
 */

/*
 * ΕΡΓΑΣΙΑ 1: ΑΛΕΞΑΝΔΡΟΣ ΔΡΙΔΑΚΗΣ - 3836 + ΧΡΙΣΤΟΔΟΥΛΟΣ ΑΝΕΥΛΑΒΗΣ - 3840
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static File path = new File("C:\\Files");

    public static void main(String[] args) {

        FileLoader loadFiles = new FileLoader();

        loadFiles.openDirectory(path);

        ArrayList<Word> wordList = loadFiles.getWords();

        Node root = new Node(new Word("ROOT", null));
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value "
                + root.value.getText());
        System.out.println("----------------------------------");

        for (Word word : wordList) {
            root.insert(root, word);
        }

        root.setWordCounter(wordList.size());

        System.out.println("Traversing tree in order");
        root.printInOrder(root);

        System.out.println("\nTotal number of words: " + wordList.size());

        System.out.println("\n\nSearch in files:");
        Scanner inputString = new Scanner(System.in);
        String word = inputString.nextLine();

        ArrayList<Node> foundNodes = root.searchNodes(root, word);

        for (Node node : foundNodes) {

            if (node != null) {
                System.out.println("The word '" + node.value.getText() + "' is found ");
                Set<String> set = new HashSet<String>(node.sourceFiles);

                for (String key : set) {
                    System.out.println("\tIn " + key + ": "
                            + Collections.frequency(node.sourceFiles, key) + " times");
                }

            }
        }
    }
}
