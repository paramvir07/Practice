import java.util.*;

class Process {
    int pid, arrivalTime, burstTime;

    Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class FCFS {
    public static void main(String[] args) {
        List<Process> processes = Arrays.asList(
                new Process(1, 0, 4),
                new Process(2, 1, 3),
                new Process(3, 2, 1),
                new Process(4, 3, 2)
        );

        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0;
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }
            System.out.println("Process " + p.pid + " starts at " + currentTime);
            currentTime += p.burstTime;
            System.out.println("Process " + p.pid + " finishes at " + currentTime);
        }
    }
}
