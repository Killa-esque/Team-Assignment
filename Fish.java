public class Fish extends Animal implements Hunt {
    private double size;
    private String shape;

    public Fish(String aID, String aName, double size, String shape) {
        super(aID, aName);
        this.size = size;
        this.shape = shape;
    }

    public String getShape() {
        return shape;
    }
    public void setShape(String shape) {
        this.shape = shape;
    }
    public double getSize() {
        return size;
    }
    public void setSize(double size) {
        this.size = size;
    }
    public String toString(){
        return String.format("%s_%s_%s_%s",super.getaID(),super.getaName(),String.valueOf(getSize()),getShape());
    }
    @Override
    public boolean hunt() {
        return false;
    }
    
}
