public class Bird extends Animal implements Beak, Hunt {
    private String color;
    private String kind;

    public Bird(String aID, String aName, String color, String kind) {
        super(aID, aName);
        this.color = color;
        this.kind = kind;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getKind() {
        return kind;
    }
    public void setKind(String kind) {
        this.kind = kind;
    }
    public String toString(){
        return String.format("%s_%s_%s_%s",super.getaID(),super.getaName(),getColor(),getKind());
    }
    @Override
    public boolean hunt() {
        return true;
    }

    @Override
    public boolean beak() {
        return true;
    }
}
