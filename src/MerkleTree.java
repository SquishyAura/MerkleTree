
import java.security.MessageDigest;

public class MerkleTree implements IMerkleTree
{
    MessageDigest md;
    MerkleTree leftTree;
    MerkleTree rightTree;
    Leaf leftLeaf;
    Leaf rightLeaf;
    byte[] digestedData;
    
    public MerkleTree(MessageDigest md) {
        this.md = md;
        leftTree = null;
        rightTree = null;
        leftLeaf = null;
        rightLeaf = null;
        digestedData = null;
    }

    @Override
    public void add(MerkleTree leftTree, MerkleTree rightTree) {
        this.leftTree = leftTree;
        this.rightTree = rightTree;
        
        this.md.update(leftTree.digest()); //update method processes the input data, where the digest method is then used to complete the hash computation
        this.md.update(rightTree.digest());
        digestedData = this.md.digest();
        this.md.reset();
    }

    @Override
    public void add(Leaf leftLeaf, Leaf rightLeaf) {
        this.leftLeaf = leftLeaf;
        this.rightLeaf = rightLeaf;
        
        this.md.update(leftLeaf.digest());
        this.md.update(rightLeaf.digest());
        digestedData = this.md.digest();
        this.md.reset();
    }

    @Override
    public MerkleTree leftTree() {
        return leftTree;
    }

    @Override
    public MerkleTree rightTree() {
        return rightTree;
    }

    @Override
    public Leaf leftLeaf() {
        return leftLeaf;
    }

    @Override
    public Leaf rightLeaf() {
        return rightLeaf;
    }

    @Override
    public byte[] digest() {
        return digestedData;
    }

    @Override
    public void printTree() {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte bytes : digestedData) {
            stringBuffer.append(String.format("%02x", bytes & 0xff));
        }
        System.out.println("index : " + stringBuffer.toString());
    }
}
