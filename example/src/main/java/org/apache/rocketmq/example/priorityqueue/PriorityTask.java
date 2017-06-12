package org.apache.rocketmq.example.priorityqueue;

import java.util.concurrent.Callable;

/**
 * Created by lewis0077 on 2017/6/12.
 */
public class PriorityTask implements Callable<Student>,Comparable<PriorityTask> {
    private int priorityLevel;

    public PriorityTask(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public int compareTo(PriorityTask o) {
        return priorityLevel>o.priorityLevel?-1:(priorityLevel<o.priorityLevel?1:0);
    }

    @Override
    public Student call() throws Exception {
       Thread.sleep(1000);
        Student student = new Student(priorityLevel,"name_"+priorityLevel,"hobby_"+priorityLevel);
        System.out.println(student);
        return student;
    }
}
