public class Leaf {
    byte[] digestedData;
    
    public Leaf(byte[] byteData){
        this.digestedData = byteData;
    }
    
    public byte[] digest() {
        return digestedData;
    }
}
