
/**
 * Write a description of class CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
private String alphabet;
private String alphabetL;
private String shiftedAlphabet1;
private String shiftedAlphabet1L;
private String shiftedAlphabet2;
private String shiftedAlphabet2L;
private int mainkey1;
private int mainkey2;


public CaesarCipherTwo(int key1, int key2) {
alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
alphabetL = "abcdefghijklmnopqrstuvwxyz";
shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
shiftedAlphabet1L = alphabetL.substring(key1) + alphabetL.substring(0, key1);
shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
shiftedAlphabet2L = alphabetL.substring(key2) + alphabetL.substring(0, key2);
mainkey1 = key1;
mainkey2 = key2;
     }
     
public String encryptTwoKeys(String input) {
    StringBuilder encrypted = new StringBuilder(input);

    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        int id = alphabet.indexOf(currChar);
        if (id != -1 && i%2 == 0) {
        char newChar = shiftedAlphabet1.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
        if (id != -1 && i%2 != 0) {
        char newChar = shiftedAlphabet2.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
    }
    for (int i = 0; i < encrypted.length(); i++) {
        char currChar = encrypted.charAt(i);
        int id = alphabetL.indexOf(currChar);
        if (id != -1 && i%2 == 0) {
        char newChar = shiftedAlphabet1L.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
        if (id != -1 && i%2 != 0) {
        char newChar = shiftedAlphabet2L.charAt(id);
        encrypted.setCharAt(i, newChar);
        }
    }
    //System.out.println(encrypted);
    return encrypted.toString();
    }  
    
public String decryptTwoKeys(String message) {
    CaesarCipherTwo cc = new CaesarCipherTwo(26-mainkey1,26-mainkey2);
    String Final = cc.encryptTwoKeys(message);
    //System.out.println("Decrypt Key1 is " + (26 - mainkey1) + " Key2 is :" + (26 - mainkey2) + " for message : " + Final);
    return Final;
    
    
    //CaesarCipherTwo cc2 = new CaesarCipherTwo(26 - mainkey1, 26 - mainkey1);
    //System.out.println("First Key is " + (26 - mainkey1) + " Second Key is " + (26 - mainkey2));
    //String Final = cc2.encryptTwoKeys(message);
    //System.out.println("Decrypted message is " + Final);
    //return Final;
    }
}
