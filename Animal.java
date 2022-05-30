public class Animal {
    protected String aID;
    protected String aName;

    public Animal(String aID, String aName) {
        this.aID = aID;
        this.aName = aName;
    }

    public String getaID() {
        return aID;
    }
    public void setaID(String aID) {
        this.aID = aID;
    }
    public String getaName() {
        return aName;
    }
    public void setaName(String aName) {
        this.aName = aName;
    }
}
