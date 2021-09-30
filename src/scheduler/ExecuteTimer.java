package scheduler;


import java.util.Timer;

public class ExecuteTimer {

  public static void main(String[] args){
      TimerExample task1=new TimerExample("Task1");
      //TimerExample task2=new TimerExample("Task2");

      Timer t=new Timer();
      //t.scheduleAtFixedRate(te1, 0,5*1000);
      //t.scheduleAtFixedRate(te2, 0,1000);
      
      t.scheduleAtFixedRate(task1, 0, 1000);
   }
}
