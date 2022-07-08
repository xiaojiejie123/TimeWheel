package com.czz.time.wheel;

import java.util.concurrent.TimeUnit;

/**
 * @author chaizezhao
 * @date 2022/7/8
 */
public class TimerTask extends Thread {
    /**
     * 延迟时间
     */
    private long delayTime;
    /**
     * 前一个节点
     */
    public TimerTask pre;
    /**
     * 后一个节点
     */
    public TimerTask next;

    /**
     * 需要运行的任务
     */
    private Runnable task;

    TimerTask(long delayTime, Runnable task) {
        this.delayTime = delayTime;
        this.task = task;
    }

    private long getDelayTime() {
        return delayTime;
    }

    private void setDelayTime(long delayTime, TimeUnit timeUnit) {
        this.delayTime = timeUnit.toMillis(delayTime);
    }
}
