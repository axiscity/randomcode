import javax.management.timer.Timer;

public class JavaReminder {
    Timer timer;

    public JavaReminder(int seconds) {
        timer = new Timer();  //At this line a new Thread will be created
        timer.schedule(new RemindTask(), seconds*1000); //delay in milliseconds
    }

    class RemindTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("ReminderTask is completed by Java timer");
            timer.cancel(); //Not necessary because we call System.exit
            //System.exit(0); //Stops the AWT thread (and everything else)
        }
    }

    public static void main(String args[]) {
        System.out.println("Java timer is about to start");
        JavaReminder reminderBeep = new JavaReminder(5);
        System.out.println("Remindertask is scheduled with Java timer.");
    }
}


Read more: https://javarevisited.blogspot.com/2013/02/what-is-timer-and-timertask-in-java-example-tutorial.html#ixzz64iPT5Ykh