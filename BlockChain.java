package Blockchain;

import java.util.ArrayList;

public class BlockChain {
    private ArrayList<Block> chain;

    public BlockChain() {
        chain = new ArrayList<>();
        // Add the genesis block automatically
        chain.add(createGenesisBlock());
    }

    // Method to create the first block in the blockchain with predefined values
    private Block createGenesisBlock() {
        UserData genesisUserData = new UserData("genesisUser", "Genesis Block", "genesis@example.com", 1234567890, new java.util.Date(), "encryptedPassword");
        return new Block(genesisUserData, "0");
    }

    // Method to add a block to the blockchain
    public void addBlock(UserData data) {
        Block lastBlock = chain.get(chain.size() - 1);
        Block newBlock = new Block(data, lastBlock.getHash());
        newBlock.mineBlock(4);  // Assuming a difficulty level of 4 for simplicity
        chain.add(newBlock);
    }

    // Method to check the integrity of the blockchain
    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            // Check if the current block's hash is what it should be
            if (!currentBlock.getHash().equals(currentBlock.calculateBlockHash())) {
                return false;
            }

            // Check if the current block's previous hash is equal to the previous block's hash
            if (!currentBlock.getPreviousHash().equals(previousBlock.getHash())) {
                return false;
            }
        }
        return true;
    }

    // Get the whole blockchain
    public ArrayList<Block> getChain() {
        return chain;
    }
}
