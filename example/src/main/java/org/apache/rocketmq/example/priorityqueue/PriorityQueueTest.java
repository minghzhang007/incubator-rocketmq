package org.apache.rocketmq.example.priorityqueue;

import java.util.concurrent.*;

/**
 * Created by lewis0077 on 2017/6/12.
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        int  coreSize = Runtime.getRuntime().availableProcessors();
        int poolSize = coreSize * 2;
        BlockingQueue workQueue = new PriorityBlockingQueue();
        ThreadPoolExecutor executor = new MyThreadPoolExeuctor(1,4,60L, TimeUnit.SECONDS,workQueue,
                new MyThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());


        for (int i = 0; i < 100; i++) {
            executor.submit(new PriorityTask(0));
        }

        for (int i = 20; i < 30; i++) {
            executor.submit(new PriorityTask(1));
        }
    }

    private static class MyThreadFactory implements ThreadFactory{

        /**
         * Constructs a new {@code Thread}.  Implementations may also initialize
         * priority, name, daemon status, {@code ThreadGroup}, etc.
         *
         * @param r a runnable to be executed by new thread instance
         * @return constructed thread, or {@code null} if the request to
         * create a thread is rejected
         */
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r,"myThread");
            return t;
        }
    }
}
