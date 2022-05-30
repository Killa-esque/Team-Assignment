public class OfficeStaff extends Staff {
    private int shift;
    private String service;

    public OfficeStaff(String sID, String sName, int shift) {
        super(sID, sName);
        this.shift = shift;
        
    }

    public String getService() {
        return service;
    }
    public void setService(String service) {
        this.service = service;
    }
    public int getShift() {
        return shift;
    }
    public void setShift(int shift) {
        this.shift = shift;
    }
    public Double paySalary(double baseSalary,int workingTime) {
        if (shift <= 3){
            return baseSalary * workingTime;
        }
        else{
            return baseSalary * workingTime * 1000000;
        }
    }
    @Override
    public String toString (){
        return String.format("%s_%s_%s",super.getsID(),super.getsName(),String.valueOf(getShift()));
    }
    
}