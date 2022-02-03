package src.main.java;

public class TimeTracker {

    private long beforeTime;
    private long totalTime;

    public long getTotalTime() {
        totalTime = System.currentTimeMillis() - beforeTime;
        return totalTime;
    }

    public TimeTracker(){
        beforeTime = System.currentTimeMillis();
    }


}
