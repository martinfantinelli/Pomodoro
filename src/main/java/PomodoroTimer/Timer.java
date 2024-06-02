package PomodoroTimer;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Timer {
    int restCount = 0;
    boolean restOn = false;
    int pomoCount = 0;

    public void startTimer(long minutes) throws InterruptedException {
        long displayMinutes=0;
        long displaySeconds=0;
        long startTime=System.currentTimeMillis();
        System.out.println("Timer:");
        if(this.pomoCount < 4){
            while (displayMinutes < minutes) {
                TimeUnit.SECONDS.sleep(1);
                long timePassed = System.currentTimeMillis() - startTime;
                displayMinutes = TimeUnit.MILLISECONDS.toMinutes(timePassed);
                displaySeconds = TimeUnit.MILLISECONDS.toSeconds(timePassed) - (displayMinutes * 60);

                System.out.println(displayMinutes + "::" + displaySeconds);
            }
            this.pomoCount++;
            if(this.restCount <= 4 && !this.restOn){
                this.startRest();
            }
            this.restOn = false;
        }
    }

    public void startRest() throws InterruptedException {
        this.restCount++;
        this.restOn=true;
        Toolkit.getDefaultToolkit().beep();
       this.startTimer(5);
    }
}
