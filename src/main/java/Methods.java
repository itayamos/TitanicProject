import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Methods {
    public static List<Passenger> readFromCSVFile(){
        BufferedReader reader;

        List<Passenger> lp=new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(Constants.PATH_TO_DATA_FILE));
            lp = reader.lines().skip(1).map(Passenger::getPassenger).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lp;
    }
    public static List<Passenger> minId(List<Passenger> lp,int min){
        return lp.stream().filter(id->min<=id.getId()).collect(Collectors.toList());
    }
    public static List<Passenger> maxId(List<Passenger> lp,int max){
        return lp.stream().filter(id->max>=id.getId()).collect(Collectors.toList());
    }
    public static List<Passenger> minAge(List<Passenger> lp,int min){
        return lp.stream().filter(age->min<=age.getAge()).collect(Collectors.toList());
    }
    public static List<Passenger> maxAge(List<Passenger> lp,int max){
        return lp.stream().filter(age->max>=age.getAge()).collect(Collectors.toList());
    }
    public static List<Passenger> minToMaxAge(List<Passenger> lp,int min,int max){
        return lp.stream().filter(age->age.getAge()<=max&&age.getAge()>=min).collect(Collectors.toList());
    }
    public static List<Passenger> ByName(List<Passenger> lp,String name){
        return lp.stream().filter(pass->pass.getName().contains(name)).collect(Collectors.toList());
    }
    public static List<Passenger> minFare(List<Passenger> lp,double min){
        return lp.stream().filter(pass->pass.getFare()>min).collect(Collectors.toList());
    }
    public static List<Passenger> maxFare(List<Passenger> lp,double max){
        return lp.stream().filter(pass->pass.getFare()<max).collect(Collectors.toList());
    }
    public static List<Passenger> minToMaxFare(List<Passenger> lp,double min,double max) {
        return lp.stream().filter(pass -> pass.getFare() < max && pass.getFare() > min).collect(Collectors.toList());
    }
    public static List<Passenger> survived(List<Passenger> lp){
        return lp.stream().filter(Passenger::isSurvived).collect(Collectors.toList());
    }
    public static List<Passenger> NotSurvived(List<Passenger> lp){
        return lp.stream().filter(passenger -> !passenger.isSurvived()).collect(Collectors.toList());
    }
    public static List<Passenger> BySibSp(List<Passenger> lp,int sib){
        return lp.stream().filter(pass->sib==pass.getSibSp()).collect(Collectors.toList());
    }
    public static List<Passenger> ByPar(List<Passenger> lp,int par){
        return lp.stream().filter(pass->par==pass.getParch()).collect(Collectors.toList());
    }
    public static List<Passenger> ByCabin(List<Passenger> lp,String cabin){
        return lp.stream().filter(pass->pass.getCabin().equals(cabin)).collect(Collectors.toList());
    }
    public static List<Passenger> ByPClass(List<Passenger> lp,String selected){
        List<Passenger> passengers=new LinkedList<>();
        if(selected.equals("All")){
            passengers= new LinkedList<>(lp);
        }
        if (selected.equals("1st")){
            passengers=lp.stream().filter(pass->pass.getPClass()==1).collect(Collectors.toList());
        }
        if (selected.equals("2nd")){
            passengers=lp.stream().filter(pass->pass.getPClass()==2).collect(Collectors.toList());
        }
        if (selected.equals("3rd")){
            passengers=lp.stream().filter(pass->pass.getPClass()==3).collect(Collectors.toList());
        }
        return passengers;
    }
    public static List<Passenger> BySex(List<Passenger> lp,String selected){
        List<Passenger> passengers=new LinkedList<>();
        if(selected.equals("All")){
            passengers= new LinkedList<>(lp);
        }
        if(selected.equals("male")||selected.equals("female")){
            passengers=lp.stream().filter(pass->pass.getSex().equals(selected)).collect(Collectors.toList());
        }
        return passengers;
    }
    public static List<Passenger> ByEmbarked(List<Passenger> lp,String selected){
        List<Passenger> passengers=new LinkedList<>();
        if(selected.equals("All")){
            passengers= new LinkedList<>(lp);
        }
        if (selected.equals("C")||selected.equals("Q")||selected.equals("S")){
            passengers=lp.stream().filter(pass-> pass.getEmbarked().equals(selected)).collect(Collectors.toList());
        }
        return passengers;
    }
    public static List<Passenger> ByTicket(List<Passenger> lp,String ticket){
        return lp.stream().filter(pass-> pass.getTicket().equals(ticket)).collect(Collectors.toList());
    }
    public static List<Passenger> haveFamily(List<Passenger> lp){
        return lp.stream().filter(Passenger::hasFamily).collect(Collectors.toList());
    }
    public static List<Passenger> haveNoFamily(List<Passenger> lp){
        return lp.stream().filter(pass-> !pass.hasFamily()).collect(Collectors.toList());
    }
    public static String StatByGender(String gender){
        int part=survived(BySex(readFromCSVFile(),gender)).size();
        int whole=BySex(readFromCSVFile(),gender).size();
        return precent(whole,part);
    }
    public static String StatByEmbarked(String port){
        int part=survived(ByEmbarked(readFromCSVFile(),port)).size();
        int whole=ByEmbarked(readFromCSVFile(),port).size();
        return precent(whole,part);
    }
    public static String StatByFare(int min,int max){
        int part=survived(minToMaxFare(readFromCSVFile(),min,max)).size();
        int whole=minToMaxFare(readFromCSVFile(),min,max).size();
        return precent(whole,part);
    }
    public static String StatByMaxFare(int max){
        int part=survived(maxFare(readFromCSVFile(),max)).size();
        int whole=maxFare(readFromCSVFile(),max).size();
        return precent(whole,part);
    }
    public static String StatByMinFare(int min){
        int part=survived(minFare(readFromCSVFile(),min)).size();
        int whole=minFare(readFromCSVFile(),min).size();
        return precent(whole,part);
    }
    public static String StatByAge(int min,int max){
        int part=survived(minToMaxAge(readFromCSVFile(),min,max)).size();
        int whole=minToMaxAge(readFromCSVFile(),min,max).size();
        return precent(whole,part);
    }
    public static String StatByMinAge(int min){
        int part=survived(minAge(readFromCSVFile(),min)).size();
        int whole=minAge(readFromCSVFile(),min).size();
        return precent(whole,part);
    }
    public static String StatByClass(String p){
        int part=survived(ByPClass(readFromCSVFile(),p)).size();
        int whole=ByPClass(readFromCSVFile(),p).size();
        return precent(whole,part);
    }
    public static String StatByHaveFamily(){
        int part=survived(haveFamily(readFromCSVFile())).size();
        int whole=haveFamily(readFromCSVFile()).size();
        return precent(whole,part);
    }
    public static String StatByHaveNoFamily(){
        int part=survived(haveNoFamily(readFromCSVFile())).size();
        int whole=haveNoFamily(readFromCSVFile()).size();
        return precent(whole,part);
    }
    public static String precent(int whole,int part){
        return (double)((part*100)/whole)+"%";
    }
}
