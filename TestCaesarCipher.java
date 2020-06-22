import edu.duke.*;
import java.io.*;
/**
 * Write a description of class TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipher {

public int[] counts(String message) {
    String alph = "abcdefghijklmnopqrstuvwxyz";
    int[] countS = new int[26];
    for (int i = 0; i < message.length(); i++) {
        char ch = Character.toLowerCase(message.charAt(i));
        int dex = alph.indexOf(ch);
        if (dex != -1) {
        countS[dex] += 1;
        //System.out.println(countS[dex]);
        }
    }      
    return countS;
    
}


public int findkey(int[] vals) {
        
        int indOfMax = 0;
        int maxSoFar = vals[0];
        
        for (int i=1;i<vals.length;i++){
        
            if (vals[i]>maxSoFar) {
                maxSoFar = vals[i];
                indOfMax = i;
                //System.out.println(indOfMax);
            }
        }
        //System.out.println(indOfMax);
        return indOfMax;
    }    
    
    
public String breakCaesarCipher(String message) {
    int[] freqs = counts(message);
    int key = findkey(freqs);
    int dkey = key - 4;
    if (key < 4) {
     dkey = 26 - (4-key);
    }
    System.out.println("The encrypted key is " + dkey);
    CaesarCipher cc = new CaesarCipher(dkey);
    String Final = cc.decrypt(message);
    //System.out.println("Decrypted message is : " + Final);
    return Final;
    }
    

public void simpleTests() {
    //FileResource fr = new FileResource();
    //String message = fr.asString();
    String manualencrypted = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
    //System.out.println(message);
    CaesarCipher cc = new CaesarCipher(15);
    String encrypted = cc.encrypt(manualencrypted);
    System.out.println("Encrypted is : " + encrypted);
    //String decrypted = cc.decrypt(encrypted);
    //System.out.println("Decrypted is : " + decrypted);
    System.out.println("Decrypted message from unknowm key is :" + breakCaesarCipher(encrypted));
}
    }

