package Blockchain;
import java.util.*;
import java.security.MessageDigest;
public class Block {

    private String hash;
    private String prevhash;
    private UserData data;
    private long timeStamp;
    private int nonce;

    public Block(UserData data, String prevhash) {
        this.data = data;
        this.prevhash = prevhash;
        this.timeStamp = new Date().getTime();
        this.nonce = 0;  // Initialize nonce
        this.hash = calculateBlockHash();
    }

    public String calculateBlockHash() {
        String dataToHash = prevhash + Long.toString(timeStamp) + Integer.toString(nonce) + data.toSingleHashString();
        return StringUtil.applySha256(dataToHash);
    }

    // Method to simulate the mining process
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0'); // Create a string with difficulty * "0" 
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = calculateBlockHash();
        }
    }

    // Getters
    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return prevhash;
    }

    public UserData getData() {
        return data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public int getNonce() {
        return nonce;
    }

    // Setters
    public void setHash(String hash) {
        this.hash = hash;
    }

    public void setPreviousHash(String prevhash) {
        this.prevhash = prevhash;
    }

    public void setData(UserData data) {
        this.data = data;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }
    public class StringUtil {
        // Applies Sha256 to a string and returns the result.
        public static String applySha256(String input) {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256");
                // Applies sha256 to our input,
                byte[] hash = digest.digest(input.getBytes("UTF-8"));
                StringBuilder hexString = new StringBuilder(); // This will contain hash as hexadecimal
                for (byte elem : hash) {
                    String hex = Integer.toHexString(0xff & elem);
                    if (hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }
                return hexString.toString();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
