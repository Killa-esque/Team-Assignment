public class Trainer extends Staff {
    private String workPlace;

    public Trainer(String sID, String sName, String workPlace) {
        super(sID, sName);
        this.workPlace = workPlace;
    }

    public String getWorkPlace() {
        return workPlace;
    }
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }
    public Double paySalary(double baseSalary, int workingTime) {
        if (workPlace.equals("A")){
            return baseSalary * workingTime + 100000;
        }
        else if (workPlace.equals("B")){
            return baseSalary * workingTime + 200000;
        }
        else if (workPlace.equals("C")){
            return baseSalary * workingTime + 150000;
        }
        else{
            return baseSalary * workingTime + 300000;
        }
    }
    @Override
    public String toString (){
        return String.format("%s_%s_%s",super.getsID(),super.getsName(),getWorkPlace());
    }
}
