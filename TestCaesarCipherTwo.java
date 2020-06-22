import edu.duke.*;
import java.io.*;
/**
 * Write a description of class TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestCaesarCipherTwo {
public String halfOfString(String message, int start) {
    StringBuilder sb = new StringBuilder();
    for (int i=0; i<message.length(); i++)
    {
    if (start % 2 == 0 && i%2 == 0) {
    char curr1 = message.charAt(i);
    sb.append(curr1);
     }
     if (start % 2 != 0 && i%2 != 0) {
     char curr1 = message.charAt(i);
     sb.append(curr1);
     }

     }
        String half = sb.toString();
        return half;
}

public int[] counts(String message) {
    String alph = "abcdefghijklmnopqrstuvwxyz";
    int[] countS = new int[26];
    for (int i = 0; i < message.length(); i++) {
        char ch = Character.toLowerCase(message.charAt(i));
        int dex = alph.indexOf(ch);
        if (dex != -1) {
        countS[dex] += 1;
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

public int getkey(String message) {
    int[] numbers = counts(message);
    int maxindex = findkey(numbers);
    return maxindex;
    
}

public String breakCaesarCipher2(String message) {      
    String First = halfOfString(message, 0);
    System.out.println(First);
    String Second = halfOfString(message, 1);
    System.out.println(Second);   

    int getkey1 = getkey(First);

    int getkey2 = getkey(Second);
    int dkey1 = getkey1-4;
    if (getkey1 < 4) {
    dkey1 = 26 - (4-getkey1);
    }
    int dkey2 = getkey2-4;
    if (getkey2 < 4) {
    dkey2 = 26 - (4-getkey2);
    }
    System.out.println(dkey1);
    System.out.println(dkey2);
    CaesarCipherTwo cc = new CaesarCipherTwo(dkey1,dkey2);
    String Final = cc.decryptTwoKeys(message);
    System.out.println(Final);
    return Final;   
    }
    
    

public void simpleTests() {
    FileResource fr = new FileResource();
    String manualencrypted = fr.asString();
    //String manualencrypted = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
    System.out.println(manualencrypted);
    //CaesarCipherTwo cc = new CaesarCipherTwo(14, 24);
    //String encrypted = cc.encryptTwoKeys(manualencrypted);
    //System.out.println("Encrypted is : " + encrypted);
    //String decrypted = cc.decryptTwoKeys(manualencrypted);
    //System.out.println("Decrypted is : " + decrypted);
    System.out.println("Decrypted message from unknowm keys is :" + breakCaesarCipher2(manualencrypted));
    //System.out.println("Decrypted message from unknowm key is :" + breakCaesarCipher(encrypted));
}
}
    