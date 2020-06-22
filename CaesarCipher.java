import edu.duke.*;
import java.io.*;
/**
 * Write a description of class CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private String alphabetL;
    private String shiftedAlphabetL;
    private int mainKey;
    
    
public CaesarCipher(int key) {
    alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    alphabetL = "abcdefghijklmnopqrstuvwxyz";
    shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    shiftedAlphabetL = alphabetL.substring(key) + alphabetL.substring(0, key);
    mainKey = key;
}
    
public String encrypt(String phrase) {
    StringBuilder encrypted = new StringBuilder(phrase);
    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        int id = alphabet.indexOf(currChar);
        if (id != -1) {
        char newChar = shiftedAlphabet.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
    }
    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        int id = alphabetL.indexOf(currChar);
        if (id != -1) {
        char newChar = shiftedAlphabetL.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
    }
    
    //System.out.println(encrypted);
    return encrypted.toString();
    }
    
    
public String decrypt(String message) {
    CaesarCipher cc = new CaesarCipher(26-mainKey);
    String Final = cc.encrypt(message);
    //System.out.println("Decrypt Key is " + (26 - mainKey) + " for message : " + Final);
    return Final;
    }
    
}

