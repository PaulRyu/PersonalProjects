package com.algorithms;

// Complete on 20NOV20

public class CaesarCipher {

    // Assignment to simulate the Caesar Cypher, given a key and message
    static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void main(String[] args) {
        int key = 23;
        String secret = "JESSICA IS BEING ATTACKED BY MINA THE BRAVE";
        String encryptedMessage = encrypt(secret, key);
        System.out.println("Original Message: " + secret);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Decrypted Message: " + elegantSolution(encryptedMessage, 26-key));

    }

    // First attempt, very messy and inefficient. Leads to index out of bounds.
    // Decrypt message
    public static String encrypt(String messageToEncrypt, int key) {
        StringBuilder encryptedMessage = new StringBuilder();
        char letterToFind;
        int indexOfLetterInAlphabet;
        char encryptedLetter;
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for (int i = 0; i < messageToEncrypt.length(); i++) {
            letterToFind = messageToEncrypt.charAt(i);
            if (letterToFind == ' ') {
                encryptedMessage.append(' ');
                continue;
            }
            indexOfLetterInAlphabet = alphabet.indexOf(letterToFind);
            encryptedLetter = shiftedAlphabet.charAt(indexOfLetterInAlphabet);
            encryptedMessage.append(encryptedLetter);
        }
        return encryptedMessage.toString();
    }

    // Second attempt, refined. Much more efficient and easy on the eyes.
    // Additionally allows for decryption by passing in the number of letters in the alphabet
    //      minus the key. Example: Running elegantSolution(encryptedMessage, 26-key)
    //      on an encrypted message will decrypt it.
    public static String elegantSolution(String messageToEncrypt, int key) {
        StringBuilder encryptedMessage = new StringBuilder(messageToEncrypt);
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);

        for (int i=0; i < encryptedMessage.length(); i++) {
            // Look at the current character
            char currChar = encryptedMessage.charAt(i);
            // Find the index of currChar in the alphabet
            int index = alphabet.indexOf(currChar);
            // If current character is in the alphabet
            if (index != -1) {
                // Get the character at the found index in the shifted alphabet
                char newChar = shiftedAlphabet.charAt(index);
                //Replace the current character of encrypted with the new char
                encryptedMessage.setCharAt(i, newChar);
            }
        }
        return encryptedMessage.toString();
    }
}