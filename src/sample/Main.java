package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class Main extends Application {
    private Label title,fnamela,lnamela,yearla,monthla,dayla,outputla;
    private TextField ftfname,ftlname,ftmonth,ftday,ftyear;
    private  Button hartRate;
    private VBox root,yearvbox,monthvbox,daybox;
    private HBox deathrate;
    @Override
    public void start(Stage primaryStage) throws Exception{
        title = new Label("Heart Rate Calculator");
        title.setStyle("-fx-font:26px Arial");
        fnamela = new Label("First Name");
        lnamela = new Label("Last Name");
        yearla = new Label("Year");
        monthla = new Label("Month");
        dayla = new Label("Day");
        outputla = new Label();
        outputla.setStyle("-fx-font: 20px Arial; -fx-text-fill: blue;");

        ftfname = new TextField();
        ftlname = new TextField();
        ftmonth = new TextField();
        ftday = new TextField();
        ftyear = new TextField();
        hartRate = new Button("Calculate Heart Rate");

        yearvbox = new VBox();
        yearvbox.getChildren().addAll(yearla,ftyear);
        monthvbox = new VBox();
        monthvbox.getChildren().addAll(monthla,ftmonth);
        daybox = new VBox();
        daybox.getChildren().addAll(dayla,ftday);
        deathrate = new HBox();
        deathrate.getChildren().addAll(yearvbox,monthvbox,daybox);
        deathrate.setSpacing(20);
        root = new VBox();
        root.getChildren().addAll(title,fnamela,ftfname,lnamela,ftlname,deathrate,hartRate,outputla);
        root.setSpacing(20);
        root.setPadding(new Insets(20));

        hartRate.setOnAction(e->{
            int year = Integer.parseInt(ftyear.getText());
            String month=ftmonth.getText();
            int day = Integer.parseInt(ftday.getText());
            String fname=ftfname.getText();
            String lname =ftlname.getText();
            String fullname=fname+" "+lname;
            Month  month2 = getMonth(month);
            int age=getAge(year,month2,day);
            double maxhartrate=getHeartRate(age);
            String thr=getTHR(maxhartrate);
            String ans;
            ans="Name : "+fullname+"\n"+"Age : "+age+"\n"+"MaxHeartRate : "+maxhartrate+"\n"+"Target Heart Rate : "+thr;
            outputla.setText(ans);

        });
        Scene scene = new Scene(root,500,500);


        primaryStage.setTitle("Heart Rate Calculator");
        primaryStage.setScene(scene);

        primaryStage.show();

    }
    private int getAge(int year, Month m,int day) {
        LocalDate today = LocalDate.now();
        LocalDate bd = LocalDate.of(year,m,day);
        Period period = Period.between(bd,today);
        return (period.getYears());
    }

    private Month getMonth(String month){
        Month m;
        if(month.equalsIgnoreCase("January")){
            m = Month.JANUARY;
        }else if(month.equalsIgnoreCase("February")){
            m = Month.FEBRUARY;
        }else if(month.equalsIgnoreCase("March")){
            m = Month.MARCH;
        }else if(month.equalsIgnoreCase("April")){
            m = Month.APRIL;
        }
        else if(month.equalsIgnoreCase("May")){
            m = Month.MAY;
        }
        else if(month.equalsIgnoreCase("June")){
            m = Month.JUNE;
        }
        else if(month.equalsIgnoreCase("July")){
            m = Month.JULY;
        }
        else if(month.equalsIgnoreCase("August")){
            m = Month.AUGUST;
        }
        else if(month.equalsIgnoreCase("September")){
            m = Month.SEPTEMBER;
        }
        else if(month.equalsIgnoreCase("October")){
            m = Month.OCTOBER;
        }
        else if(month.equalsIgnoreCase("November")){
            m = Month.NOVEMBER;
        }
        else if(month.equalsIgnoreCase("December")){
            m = Month.DECEMBER;
        }
        else {
            m = Month.JANUARY;
        }
        return m;
    }
    private  double getHeartRate(int year){
        return 220-year;
    }
    private  String getTHR(double hr) {
        return (int) (hr * 0.5) + " - " + (int) (hr * 0.85);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
