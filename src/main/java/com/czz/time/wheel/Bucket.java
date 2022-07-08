package com.czz.time.wheel;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chaizezhao
 * @date 2022/7/8
 */
public class Bucket implements Delayed {
    private AtomicLong expiration = new AtomicLong(-1L);

    private TimerTask root = new TimerTask(-1L, null);

    Bucket() {
        root.pre = root;
        root.next = root;
    }

    public void addTask(TimerTask task) {
        synchronized (this) {
            TimerTask tail = root.pre;
            tail.next = task;
            task.pre = tail;
            root.pre = task;
            task.next = root;
        }
    }

    public void removeTask(TimerTask timerTask) {

    }

    @Override
    public long getDelay(TimeUnit unit) {
        return Math.max(0, unit.convert(expiration.get() - System.currentTimeMillis(), TimeUnit.MILLISECONDS));
    }

    @Override
    public int compareTo(Delayed o) {
        if (o instanceof Bucket) {
            return Long.compare(expiration.get(), ((Bucket) o).expiration.get());
        }
        return 0;
    }
}
