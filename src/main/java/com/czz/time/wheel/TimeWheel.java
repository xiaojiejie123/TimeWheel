package com.czz.time.wheel;

import java.util.concurrent.DelayQueue;

/**
 * @author chaizezhao
 * @date 2022/7/8
 */
public class TimeWheel {
    /**
     * 时间槽精度
     */
    private long tick;
    /**
     * 时间轮大小
     */
    private int wheelSize;
    /**
     * 上一级时间轮
     */
    private TimeWheel overflowWheel;

    /**
     * 延迟队列
     */
    private DelayQueue<Bucket> delayQueue;

    /**
     * 时间槽数组
     */
    private Bucket[] buckets;

    private long startTime;

    TimeWheel(long tick, int wheelSize, long currentTime, DelayQueue<Bucket> delayQueue) {
        // 判断参数的真确性
        this.tick = tick;
        this.wheelSize = wheelSize;
        this.startTime = currentTime;
        this.delayQueue = delayQueue;

        this.buckets = new Bucket[wheelSize];
        // 初始化每个槽
        for (int i = 0; i < wheelSize; i++) {
            this.buckets[i] = new Bucket();
        }
    }

    private boolean addTask(TimerTask timerTask) {
        long delayTime =
    }
}
