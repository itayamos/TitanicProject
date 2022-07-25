import java.io.Serializable;

public class Passenger implements Serializable {
    private int id;
    private int survived;
    private int PClass;
    private String name;
    private String sex;
    private int age;
    private int sibSp;
    private int parch;
    private String ticket;
    private double fare;
    private String cabin;
    private String embarked;

    public Passenger(int id, int survived, int PClass, String name, String sex, int age, int sibSp, int parch, String ticket, double fare, String cabin, String embarked) {
        this.id = id;
        this.survived = survived;
        this.PClass = PClass;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.sibSp = sibSp;
        this.parch = parch;
        this.ticket = ticket;
        this.fare = fare;
        this.cabin = cabin;
        this.embarked = embarked;
    }
    public boolean hasFamily(){
        boolean flag=false;
        if(sibSp+parch>0){
            flag=true;
        }
        return flag;
    }
    public static String getFormattedName(String name){
        int start=0;
        int end=0;
        String str=null;
        for (int i=0; i<name.length(); i++){
            if (name.charAt(i)==','){
                start=i;
            }if (name.charAt(i)=='.'){
                end=i+1;
            }
        }
        str=name.substring(0,start);
        str+=name.substring(end,name.length());
        String[] s=str.split(" ");
        String temp=s[0];
        for (int i=1; i<s.length; i++){
            s[i-1]=s[i];
        }
        s[s.length-1]=temp;
        str="";
        for (int i=0; i<s.length; i++){
            if(str.equals("")){
                str+=s[i];
            }
            else {
                str+=" "+s[i];
            }
        }
        return str;
    }
    public static String KnownCabin(String cabin){
        StringBuilder newCabin=new StringBuilder();
        if (!cabin.equals("")){
            newCabin.append(cabin);
        }
        else {
            newCabin.append("unknown");
        }
        return newCabin.toString();
    }
    public static int KnownAge(String Age){
        int value=-1;
        if (!Age.equals("")){
            value=(int)Double.parseDouble(Age);
        }
        return value;
    }
    public boolean isSurvived(){
        boolean flag = false;
        if(getSurvived()==1){
            flag=true;
        }else if(getSurvived()==0){
            flag=false;
        }
        return flag;
    }
    public int getId() {
        return id;
    }
    public int getSurvived() {
        return survived;
    }
    public int getPClass() {
        return PClass;
    }
    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
    public int getSibSp() {
        return sibSp;
    }
    public int getParch() {
        return parch;
    }
    public String getTicket() {
        return ticket;
    }
    public double getFare() {
        return fare;
    }
    public String getCabin() {
        return cabin;
    }
    public String getEmbarked() {
        return embarked;
    }
    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", survived=" + survived +
                ", PClass=" + PClass +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", sibSp=" + sibSp +
                ", parch=" + parch +
                ", ticket='" + ticket + '\'' +
                ", fare=" + fare +
                ", cabin='" + cabin + '\'' +
                ", embarked='" + embarked + '\'' +
                '}';
    }
    public static Passenger getPassenger(String line){
        String[] fields=line.split(",");
        Passenger passenger=null;
        if (fields.length==13) {
            passenger=new Passenger(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), getFormattedName(fields[3] + fields[4]), fields[5], KnownAge(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), fields[9], Double.parseDouble(fields[10]), KnownCabin(fields[11]), fields[12]);
        }
        else if (fields.length==12){
            passenger=new Passenger(Integer.parseInt(fields[0]), Integer.parseInt(fields[1]), Integer.parseInt(fields[2]), getFormattedName(fields[3] + fields[4]), fields[5], KnownAge(fields[6]), Integer.parseInt(fields[7]), Integer.parseInt(fields[8]), fields[9], Double.parseDouble(fields[10]), KnownCabin(fields[11]), "unkown");
        }
        return passenger;
    }
}
