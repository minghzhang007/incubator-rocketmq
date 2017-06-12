package org.apache.rocketmq.example.priorityqueue;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by lewis0077 on 2017/6/12.
 */
public class ComparableFutureTask<V> extends FutureTask<V> implements Comparable<ComparableFutureTask>{

    private Object object;

    public ComparableFutureTask(Callable<V> callable) {
        super(callable);
        this.object = callable;
    }

    public ComparableFutureTask(Runnable runnable, V result) {
        super(runnable, result);
        this.object = runnable;
    }

    @Override
    public int compareTo(ComparableFutureTask o) {
        if (this == o)
            return 0;
        if (o == null)
            return -1;//high priority
        if (object != null && o.object != null) {
            if (object.getClass().equals(o.object.getClass())) {
                if (object instanceof Comparable) {
                    return ((Comparable) object).compareTo(o.object);
                }
            }
        }
        return 0;
    }
}
