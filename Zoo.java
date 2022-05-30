import java.io.*;
import java.util.*;


public class Zoo {
    private String nameZoo;
    private String locationZoo;
    private ArrayList<Staff> staffs;
    private ArrayList<Animal> animal;
    private ArrayList<Trainer> trainers;
    private ArrayList<OfficeStaff> officeStaffs;
    private ArrayList<String> times;
    

    public Zoo(String nameZoo, String locationZoo, String staffsPath, String animalsPath, String timesPath) {
        this.nameZoo = nameZoo;
        this.locationZoo = locationZoo;
        this.staffs = loadStaffs(staffsPath);
        this.animal = loadAnimals(animalsPath);
        this.times = loadFile(timesPath);
    }
    public ArrayList<Staff> getStaff(){
        return this.staffs;
    }
    public ArrayList<Animal> getAnimals(){
        return this.animal;
    }
    public ArrayList<Staff> loadStaffs(String filePath){
        ArrayList<Staff> st = new ArrayList<>();
        
        try {
            File listOfStaffs = new File(filePath);
            
            BufferedReader myReader = new BufferedReader(new FileReader(listOfStaffs));
            String lines =  myReader.readLine(); 

            while(lines != null){                 
                String[] information = lines.split(",");  
                                        
                // QL = Manager
                if (information[0].substring(0, 1).equals("A")) {
                    st.add(new OfficeStaff(information[0], information[1], Integer.parseInt(information[2])));
                }
                else {
                    st.add(new Trainer(information[0], information[1], information[2]));
                }
                //Read the next line
                lines = myReader.readLine();
            }
            myReader.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
    public ArrayList<Animal> loadAnimals(String filePath){
        ArrayList<Animal> ani = new ArrayList<>();
        
        try {
            File listOfAnimal = new File(filePath);
            
            BufferedReader myReader = new BufferedReader(new FileReader(listOfAnimal));
            String lines =  myReader.readLine(); 

            while(lines != null){                 
                String[] information = lines.split(",");  
                                        
                // QL = Manager
                if (information[0].substring(0, 1).equals("B")) {
                    ani.add(new Bird(information[0], information[1], information[2], information[3]));
                }
                else if (information[0].substring(0, 1).equals("F")) {
                    ani.add(new Fish(information[0], information[1], Double.parseDouble(information[2]), information[3]));
                }
                else{
                    ani.add(new Reptile(information[0], information[1], information[2], Boolean.parseBoolean(information[3])));
                }
                //Read the next line
                lines = myReader.readLine();
            }
            myReader.close();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return ani;
    }
    public ArrayList<Trainer> getTopFiveTrainerHighSalary() {
        ArrayList<String> timeTrainer = new ArrayList<>();
        
        Map <String,Double> mapping = new TreeMap<String, Double>();
        for (String strings : this.times){
            String[] information = strings.split(",");
            if (information[0].substring(0, 1).equals("T")) {
                timeTrainer.add(strings);
            }
        }

        for (Staff staff : staffs) {
            if (staff instanceof Trainer) {
                for (String workingTime : this.times){
                    String[] information = workingTime.split(",");
                    if (staff.getsID().equals(information[0])) {
                        mapping.put(staff.getsID(), staff.paySalary(Double.parseDouble(information[2]),Integer.parseInt(information[1])));
                    }
                }
            }
        }
        
        //USe collections to sort the map descending
        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(mapping.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        
        
        //Create a new LinkedHashMap to store the sorted map
        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        //Create a new ArrayList to store the top 5 seasonal staffs from sortedMap
        ArrayList<Trainer> topFive = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Double> entry : sortedMap.entrySet()) {
            
            for (Staff staff : staffs) {
                if (staff instanceof Trainer) {
                    if (staff.getsID().equals(entry.getKey())) {
                        topFive.add((Trainer) staff);
                    }
                }
            }
            
        }
        return topFive;
        
    }
    public ArrayList<OfficeStaff> getTopFiveOfficeStaffHighSalary() {
        ArrayList<String> timeOfficeStaff = new ArrayList<>();
        
        Map <String,Double> mapping = new TreeMap<String, Double>();
        for (String strings : this.times){
            String[] information = strings.split(",");
            if (information[0].substring(0, 1).equals("A")) {
                timeOfficeStaff.add(strings);
            }
        }

        for (Staff staff : staffs) {
            if (staff instanceof OfficeStaff) {
                for (String workingTime : this.times){
                    String[] information = workingTime.split(",");
                    if (staff.getsID().equals(information[0])) {
                        mapping.put(staff.getsID(), staff.paySalary(Double.parseDouble(information[2]),Integer.parseInt(information[1])));
                    }
                }
            }
        }
        
        //USe collections to sort the map descending
        List<Map.Entry<String, Double>> list = new LinkedList<Map.Entry<String, Double>>(mapping.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        
        
        //Create a new LinkedHashMap to store the sorted map
        Map<String, Double> sortedMap = new LinkedHashMap<String, Double>();
        for (Map.Entry<String, Double> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        
        //Create a new ArrayList to store the top 5 seasonal staffs from sortedMap
        ArrayList<OfficeStaff> topFive = new ArrayList<>();
        int i = 0;
        for (Map.Entry<String, Double> entry : sortedMap.entrySet()) {
            
            for (Staff staff : staffs) {
                if (staff instanceof OfficeStaff) {
                    if (staff.getsID().equals(entry.getKey())) {
                        topFive.add((OfficeStaff) staff);
                    }
                }
            }
        }
        return topFive;
        
    }
    public ArrayList<String> assignFor(String area){
        ArrayList <String> assign = new ArrayList<String>();
        switch (area) {
            case "Bird":
            for (Staff s : staffs){
                if (s instanceof Trainer){
                    Trainer t = (Trainer) s;
                    if (t.getWorkPlace().equals("A")){
                        assign.add(t.getsID()+"_"+t.getsName()+"_"+area);
                    }
                }
            }
                break;
                case "Fish":
                for (Staff s : staffs){
                    if (s instanceof Trainer){
                        Trainer t = (Trainer) s;
                        if (t.getWorkPlace().equals("B")){
                            assign.add(t.getsID()+"_"+t.getsName()+"_"+area);
                        }
                    }
                }
                    break;
                case "Reptile":
                for (Staff s : staffs){
                    if (s instanceof Trainer){
                        Trainer t = (Trainer) s;
                        if (t.getWorkPlace().equals("C")){
                            assign.add(t.getsID()+"_"+t.getsName()+"_"+area);
                        }
                    }
                }
                    break;

            default:
                break;
        }
        return assign;

        }
    
    
    public String getNameZoo() {
        return nameZoo;
    }
    public void setNameZoo(String nameZoo) {
        this.nameZoo = nameZoo;
    }
    public String getLocationZoo() {
        return locationZoo;
    }
    public void setLocationZoo(String locationZoo) {
        this.locationZoo = locationZoo;
    }

    public static ArrayList<String> loadFile(String filePath) {
        String data = "";
        ArrayList<String> list = new ArrayList<String>();

        try {
            FileReader reader = new FileReader(filePath);
            BufferedReader fReader = new BufferedReader(reader);

            while ((data = fReader.readLine()) != null) {
                list.add(data);
            }

            fReader.close();
            reader.close();

        } catch (Exception e) {
            System.out.println("Cannot load file");
        }
        return list;
    }

    public void displayStaffs() {
        for (Trainer t: this.trainers) {
            System.out.println(t);
        }
        for (OfficeStaff o: this.officeStaffs) {
            System.out.println(o);
        }
    }

    public <E> boolean writeFile(String path, ArrayList<E> list) {
        try {
            FileWriter writer = new FileWriter(path);
            for (E tmp : list) {
                writer.write(tmp.toString());
                writer.write("\r\n");
            }

            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error.");
            return false;
        }

        return true;
    }

    public <E> boolean writeFile(String path, E object) {
        try {
            FileWriter writer = new FileWriter(path);

            writer.write(object.toString());
            writer.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error.");
            return false;
        }

        return true;
    }

    public void addTrainer(Trainer t) {
        trainers.add(t);
    }
    public void removeTrainer(Trainer t) {
        trainers.remove(t);
    }
    public void addOfficeStaff(OfficeStaff o) {
        officeStaffs.add(o);
    }
    public void removeOfficeStaff(OfficeStaff o) {
        officeStaffs.remove(o);
    }

}
