package adrianmmudarra.es.tema4_json_acdat.model.rss;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "rss", strict = false)
public class Feed implements Serializable {
    @Element(name = "channel")
    private Channel mChannel;

    public Feed() {
    }

    public Channel getmChannel() {
        return mChannel;
    }

    public Feed(Channel mChannel) {
        this.mChannel = mChannel;
    }
}