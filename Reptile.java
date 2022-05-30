public class Reptile extends Animal implements Hunt, Walk, Slither {
    private String bodyType;
    private boolean layEgg;

    public Reptile(String aID, String aName, String bodyType, boolean layEgg) {
        super(aID, aName);
        this.bodyType = bodyType;
        this.layEgg = layEgg;
    }

    public String getBodyType() {
        return bodyType;
    }
    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    public boolean isLayEgg() {
        return layEgg;
    }
    public void setLayEgg(boolean layEgg) {
        this.layEgg = layEgg;
    }
    @Override
    public String toString (){
        return String.format("%s_%s_%s_%s",super.getaID(),super.getaName(),getBodyType(),String.valueOf(isLayEgg()));
    }

    @Override
    public boolean slither() {
        
        return true;
    }

    @Override
    public boolean walk() {
        
        return false;
    }

    @Override
    public boolean hunt() {
        
        return true;
    }
    
}
