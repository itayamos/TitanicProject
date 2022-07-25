import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MainPanel extends JPanel {
    private JComboBox<String> PClassCB;
    private JTextField minIdTF;
    private JTextField maxIdTF;
    private JTextField nameTF;
    private JTextField sibTF;
    private JTextField parchTF;
    private JTextField ticketTF;
    private JTextField minFareTF;
    private JTextField maxFareTF;
    private JTextField cabinTF;
    private JComboBox<String> sexCB;
    private JComboBox<String> embarkedCB;
    private JButton filter;
    private JButton stat;
    private String resultCB1;
    private String resultCB2;
    private String resultCB3;
    private String resultTF1;
    private String resultTF2;
    private String resultTF3;
    private String resultTF4;
    private String resultTF5;
    private String resultTF6;
    private String resultTF7;
    private String resultTF8;
    private String resultTF9;
    private List<Passenger> lp;
    private int searches;

    public void setResultTF9(String resultTF9) {
        this.resultTF9 = resultTF9;
    }
    public void setResultTF1(String resultTF1) {
        this.resultTF1 = resultTF1;
    }
    public void setResultTF2(String resultTF2) {
        this.resultTF2 = resultTF2;
    }
    public void setResultTF3(String resultTF3) {
        this.resultTF3 = resultTF3;
    }
    public void setResultTF4(String resultTF4) {
        this.resultTF4 = resultTF4;
    }
    public void setResultTF5(String resultTF5) {
        this.resultTF5 = resultTF5;
    }
    public void setResultTF6(String resultTF6) {
        this.resultTF6 = resultTF6;
    }
    public void setResultTF7(String resultTF7) {
        this.resultTF7 = resultTF7;
    }
    public void setResultTF8(String resultTF8) {
        this.resultTF8 = resultTF8;
    }
    public void setResultCB1(String resultCB1) {
        this.resultCB1 = resultCB1;
    }
    public void setResultCB2(String resultCB2) {
        this.resultCB2 = resultCB2;
    }
    public void setResultCB3(String resultCB3) {
        this.resultCB3 = resultCB3;
    }
    public MainPanel (int x, int y, int width, int height) {
        File file = new File(Constants.PATH_TO_DATA_FILE); //this is the path to the data file
        resultCB1="";resultCB2="";resultCB3="";resultTF1="";
        resultTF2="";resultTF3="";resultTF4="";resultTF5="";
        resultTF6="";resultTF7="";resultTF8="";resultTF9="";
        this.searches=0;
        this.lp=new LinkedList<>();
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        JLabel label1 = new JLabel("Passenger Class: ");
        label1.setBounds(x, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label1);
        this.PClassCB = new JComboBox<>(Constants.PASSENGER_CLASS_OPTIONS);
        this.PClassCB.setBounds(x+label1.getWidth()+10, y+label1.getY(), Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.PClassCB);
        this.PClassCB.addActionListener((e) -> {
            if(e.getSource()==PClassCB){
                setResultCB1(Objects.requireNonNull(PClassCB.getSelectedItem()).toString());
            }
        });

        JLabel label2 = new JLabel("Min id:");
        label2.setBounds(x, y+Constants.Y_MARGIN*3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label2);
        this.minIdTF=new JTextField();
        this.minIdTF.setBounds(x+40,y+Constants.Y_MARGIN*3,Constants.LABEL_WIDTH+80, Constants.LABEL_HEIGHT);
        this.add(this.minIdTF);

        JLabel label3 = new JLabel("Max id:");
        label3.setBounds(x, y+Constants.Y_MARGIN*4, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label3);
        this.maxIdTF=new JTextField();
        this.maxIdTF.setBounds(x+40,y+Constants.Y_MARGIN*4,Constants.LABEL_WIDTH+80, Constants.LABEL_HEIGHT);
        this.add(this.maxIdTF);

        JLabel label4 = new JLabel("Name:");
        label4.setBounds(x, y+Constants.Y_MARGIN*5, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label4);
        this.nameTF=new JTextField();
        this.nameTF.setBounds(x+40,y+Constants.Y_MARGIN*5,Constants.LABEL_WIDTH+80, Constants.LABEL_HEIGHT);
        this.add(this.nameTF);

        JLabel label5 = new JLabel("siblings:");
        label5.setBounds(x+Constants.X_MARGIN, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label5);
        this.sibTF=new JTextField();
        this.sibTF.setBounds(x+Constants.X_MARGIN+60,y,Constants.LABEL_WIDTH+80, Constants.LABEL_HEIGHT);
        this.add(this.sibTF);

        JLabel label6 = new JLabel("parch:");
        label6.setBounds(x+Constants.X_MARGIN, y+Constants.Y_MARGIN, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label6);
        this.parchTF=new JTextField();
        this.parchTF.setBounds(x+Constants.X_MARGIN+60,y+Constants.Y_MARGIN,Constants.LABEL_WIDTH+80, Constants.LABEL_HEIGHT);
        this.add(this.parchTF);

        JLabel label7 = new JLabel("ticket:");
        label7.setBounds(x+Constants.X_MARGIN, y+Constants.Y_MARGIN*2, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label7);
        this.ticketTF=new JTextField();
        this.ticketTF.setBounds(x+Constants.X_MARGIN+60,y+Constants.Y_MARGIN*2,Constants.LABEL_WIDTH+80, Constants.LABEL_HEIGHT);
        this.add(this.ticketTF);

        JLabel label8 = new JLabel("Min fare:");
        label8.setBounds(x+Constants.X_MARGIN, y+Constants.Y_MARGIN*3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label8);
        this.minFareTF=new JTextField();
        this.minFareTF.setBounds(x+Constants.X_MARGIN+60,y+Constants.Y_MARGIN*3,Constants.LABEL_WIDTH+80, Constants.LABEL_HEIGHT);
        this.add(this.minFareTF);

        JLabel label9 = new JLabel("Max fare:");
        label9.setBounds(x+Constants.X_MARGIN, y+Constants.Y_MARGIN*4, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label9);
        this.maxFareTF=new JTextField();
        this.maxFareTF.setBounds(x+Constants.X_MARGIN+60,y+Constants.Y_MARGIN*4,Constants.LABEL_WIDTH+80, Constants.LABEL_HEIGHT);
        this.add(this.maxFareTF);


        JLabel label = new JLabel("Cabin:");
        label.setBounds(x+Constants.X_MARGIN, y+Constants.Y_MARGIN*5, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label);
        this.cabinTF=new JTextField();
        this.cabinTF.setBounds(x+Constants.X_MARGIN+60,y+Constants.Y_MARGIN*5,Constants.LABEL_WIDTH+80, Constants.LABEL_HEIGHT);
        this.add(this.cabinTF);


        JLabel label10 = new JLabel("Gender:");
        label10.setBounds(x+Constants.X_MARGIN*2+20, y, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label10);

        this.sexCB = new JComboBox<>(Constants.GENDER_OPTIONS);
        this.sexCB.setBounds(x+Constants.X_MARGIN*2+80, y, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.sexCB);
        this.sexCB.addActionListener((e) -> {
            if(e.getSource()==sexCB){
            setResultCB2(Objects.requireNonNull(sexCB.getSelectedItem()).toString());
        }});

        JLabel label11 = new JLabel("Embarked:");
        label11.setBounds(x+Constants.X_MARGIN*2+20, y+Constants.Y_MARGIN*3, Constants.LABEL_WIDTH, Constants.LABEL_HEIGHT);
        this.add(label11);

        this.embarkedCB = new JComboBox<>(Constants.EMBARKED_OPTIONS);
        this.embarkedCB.setBounds(x+Constants.X_MARGIN*2+100, y+Constants.Y_MARGIN*3, Constants.COMBO_BOX_WIDTH, Constants.COMBO_BOX_HEIGHT);
        this.add(this.embarkedCB);
        this.embarkedCB.addActionListener((e) -> {
            if(e.getSource()==embarkedCB){
                setResultCB3(Objects.requireNonNull(embarkedCB.getSelectedItem()).toString());
            }
        });
        JLabel survived=new JLabel();
        survived.setBounds(x+Constants.X_MARGIN,y+Constants.Y_MARGIN*12,Constants.LABEL_WIDTH*2,Constants.COMBO_BOX_HEIGHT);
        this.add(survived);
        this.filter=new JButton("filter");
        this.filter.setBounds(x+Constants.X_MARGIN,y+Constants.Y_MARGIN*6,Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.filter);
        this.filter.addActionListener((e) -> {
            this.lp= Methods.readFromCSVFile();
            survived.setText("wait....");
            setResultTF1(minIdTF.getText());
            setResultTF2(maxIdTF.getText());
            setResultTF3(nameTF.getText());
            setResultTF4(sibTF.getText());
            setResultTF5(parchTF.getText());
            setResultTF6(ticketTF.getText());
            setResultTF7(minFareTF.getText());
            setResultTF8(maxFareTF.getText());
            setResultTF9(cabinTF.getText());
            if(e.getSource()==filter){
                if (!resultCB1.equals("")){
                    lp= Methods.ByPClass(lp,resultCB1);
                }
                if (!resultCB2.equals("")){
                    lp= Methods.BySex(lp,resultCB2);
                }
                if (!resultCB3.equals("")){
                    lp= Methods.ByEmbarked(lp,resultCB3);
                }
                if (!resultTF1.equals("")){
                    lp= Methods.minId(lp,returnInteger(resultTF1));
                }
                if (!resultTF2.equals("")){
                    lp= Methods.maxId(lp,returnInteger(resultTF2));
                }
                if (!resultTF3.equals("")){
                    lp= Methods.ByName(lp,resultTF3);
                }
                if (!resultTF4.equals("")){
                    lp= Methods.BySibSp(lp,returnInteger(resultTF4));
                }
                if (!resultTF5.equals("")){
                    lp= Methods.ByPar(lp,returnInteger(resultTF5));
                }
                if (!resultTF6.equals("")){
                    lp= Methods.ByTicket(lp,resultTF6);
                }
                if (!resultTF7.equals("")&&!resultTF8.equals("")){
                    double min=returnDouble(resultTF7);
                    double max= returnDouble(resultTF8);
                    if(min<=max) {
                        lp = Methods.minToMaxFare(lp,min,max);
                    }
                }
                if (resultTF7.equals("")||resultTF8.equals("")) {
                    if (!resultTF7.equals("")) {
                        lp = Methods.maxFare(lp, returnDouble(resultTF7));
                    }
                    if (!resultTF8.equals("")) {
                        lp = Methods.minFare(lp, returnDouble(resultTF8));
                    }
                }
                if(!resultTF9.equals("")){
                    lp= Methods.ByCabin(lp,String.valueOf(returnInteger(resultTF9)));
                }
                survived.setText("Total Rows: "+lp.size()+"("+ Methods.survived(lp).size()+"survived"+","+ Methods.NotSurvived(lp).size()+"did not)");
                searches++;
                String line="";
                StringBuilder total= new StringBuilder();
                Passenger passenger;
                for(int i=0;i<lp.size();i++){
                    passenger=lp.get(i);
                    line=passenger.getId()+","+
                            passenger.getSurvived()+","+passenger.getPClass()+","+
                            passenger.getName()+","+passenger.getSex()+","+passenger.getAge()+","+
                            passenger.getSibSp()+","+passenger.getParch()+","+passenger.getTicket()+","+
                            passenger.getFare()+","+passenger.getCabin()+","+passenger.getEmbarked();
                        total.append(line).append('\n');
                }
                WriteToFile(total.toString(),Constants.PATH_TO_SEARCH_FILE+searches+".csv");

            }
        });

        JLabel label12=new JLabel("create statistics file:");
        label12.setBounds(x+Constants.X_MARGIN,y+Constants.Y_MARGIN*7,Constants.LABEL_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(label12);

        this.stat=new JButton("create");
        this.stat.setBounds(x+Constants.X_MARGIN,y+Constants.Y_MARGIN*8,Constants.COMBO_BOX_WIDTH,Constants.COMBO_BOX_HEIGHT);
        this.add(this.stat);
        this.stat.addActionListener((e) -> {
            if(e.getSource()==stat){
                WriteToFile("Male: "+ Methods.StatByGender("male")+'\n'+
                        "Female: "+ Methods.StatByGender("female")+'\n'+
                        "Have Family: "+ Methods.StatByHaveFamily()+'\n'+
                        "Have No Family: "+ Methods.StatByHaveNoFamily()+'\n'+
                        "1st class: "+ Methods.StatByClass("1st")+'\n'+
                        "2nd class: "+ Methods.StatByClass("2nd")+'\n'+
                        "3rd class: "+ Methods.StatByClass("3rd")+'\n'+
                        "C: "+ Methods.StatByEmbarked("C")+'\n'+
                        "Q: "+ Methods.StatByEmbarked("Q")+'\n'+
                        "S: "+ Methods.StatByEmbarked("S")+'\n'+
                        "less than 10 GBP: "+ Methods.StatByMaxFare(10)+'\n'+
                        "between 10-30 GBP: "+ Methods.StatByFare(10,30)+'\n'+
                        "more than 30 GBP: "+ Methods.StatByMinFare(30)+'\n'+
                        "between 0-10: "+ Methods.StatByAge(0,10)+'\n'+
                        "between 11-20: "+ Methods.StatByAge(11,20)+'\n'+
                        "between 21-30: "+ Methods.StatByAge(21,30)+'\n'+
                        "between 31-40: "+ Methods.StatByAge(31,40)+'\n'+
                        "between 41-50: "+ Methods.StatByAge(41,50)+'\n'+
                        "more than 51: "+ Methods.StatByMinAge(51)
                        ,Constants.PATH_TO_STAT_FILE);
            }
        });
        //0-10, 11-20, 21-30, 31-40, 41-50, 51+
        //x<10,10<=x<30,30<=x
        //parch+sibsp>0
        //male,female
        //1st,2nd,3rd
        //Q,S,C
    }
    public static int returnInteger(String s){
        int result=0;
        if (isInteger(s)){
            result=Integer.parseInt(s);
            if (result<0){
                result=0;
            }
        }
        return result;
    }
    public static boolean isInteger(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static double returnDouble(String s){
        double result=0;
        if (isDouble(s)){
            result=Double.parseDouble(s);
            if (result<0){
                result=0;
            }
        }
        return result;
    }
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static void WriteToFile(String text, String path){
        try{
            FileWriter fileWriter=new FileWriter(path);
            fileWriter.write(text);
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}