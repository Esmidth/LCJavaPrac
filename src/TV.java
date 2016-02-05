/**
 * Created by Great Esmidth on 2016/2/1.
 * Stay Foolish
 */
public class TV {
    public static final int MAX_VOLUME = 10;
    public static final int DEFAULT_CHANNEL = 2;
    public static final int DEFAULT_VOLUME = 4;

    int channel, volume;

    public TV() {
        this(DEFAULT_CHANNEL, DEFAULT_VOLUME);
    }

    public TV(int channel, int volume) {
        this.channel = channel;
        this.volume = volume;
    }

    public void switchChannel(int channel) {
        this.channel = channel;
    }

    public void changeVolume(int volume) {
        this.volume = volume;
    }

    public int recallChannel() {
        return channel;
    }
}

