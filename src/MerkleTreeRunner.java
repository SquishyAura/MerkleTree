
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author doalf
 */
public class MerkleTreeRunner {
    public static void main(String[] args) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA");
        
        MerkleTree merkleTree1 = new MerkleTree(md);
        Leaf leaf1 = new Leaf("hello".getBytes());
        Leaf leaf2 = new Leaf("world".getBytes());
        
        merkleTree1.add(leaf1, leaf2);
        merkleTree1.printTree();
        
        MerkleTree merkleTree2 = new MerkleTree(md);
        Leaf leaf3 = new Leaf("g".getBytes());
        Leaf leaf4 = new Leaf("n".getBytes());
        
        merkleTree2.add(leaf3, leaf4);
        merkleTree2.printTree();
        
        MerkleTree merkleTree3 = new MerkleTree(md);
        merkleTree3.add(merkleTree1, merkleTree2);
        merkleTree3.printTree();
    }
}
