package Blockchain;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // Initialize the blockchain
        BlockChain myBlockChain = new BlockChain();

        // Add some blocks to the blockchain with UserData
        myBlockChain.addBlock(new UserData("sandy1289", "Sanskar Sawane", "sawanesanskar07@gmail.com", 87, new Date(), "encryptedPassword1"));
        myBlockChain.addBlock(new UserData("shanu", "Ruchita Bansinge", "8shanu53@gmail.com", 97, new Date(), "encryptedPassword2"));

        // Check the integrity of the blockchain
        System.out.println("Is the blockchain valid? " + myBlockChain.isChainValid());

        // Print the blockchain
        for (Block block : myBlockChain.getChain()) {
            System.out.println("Block Hash: " + block.getHash());
            System.out.println("Previous Hash: " + block.getPreviousHash());
            System.out.println("Block Data: " + block.getData().toSingleHashString());
            System.out.println("Timestamp: " + block.getTimeStamp());
            System.out.println("--------------------------------");
        }
    }
}
