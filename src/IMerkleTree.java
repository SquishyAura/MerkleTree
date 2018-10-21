
import java.security.MessageDigest;

public interface IMerkleTree
{
    public void add(MerkleTree leftTree, MerkleTree rightTree);
    public void add(Leaf leftLeaf, Leaf rightLeaf);
    public MerkleTree leftTree(); // Returns left tree
    public MerkleTree rightTree();
    public Leaf leftLeaf(); // Returns left leaf (or null if not existent)
    public Leaf rightLeaf();
    public byte[] digest(); // Return the root node digest
    public void printTree(); // Prints the tree from the root node
}
