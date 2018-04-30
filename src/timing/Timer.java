package timing;

/**
 * Simple timer class.
 * <p>
 * The timer is a passive timer, it does not update itself or update the invoker
 * when finished. Only when asked if the timer has finished, it will respond.
 */
public class Timer {

    private long start;
    private long length;
    private boolean started;

    /**
     * @param length Length in the amount of milliseconds
     */
    public Timer(long length) {
        this.length = length;
        this.started = false;
    }

    /**
     * Starts the timer
     */
    public void start() {
        started = true;
        start = System.currentTimeMillis();
    }

    /**
     * @return True if the timer has been started, false otherwise
     */
    public boolean isStarted() {
        return started;
    }

    /**
     * @return True if the timer has been started and the current time
     * exceeded the start time plus length
     */
    public boolean finished() {
        if (started && System.currentTimeMillis() > start + length) {
            started = false;
            return true;
        } else {
            return false;
        }
    }
}
