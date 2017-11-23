import com.google.gson.Gson;
import org.xml.sax.ext.DeclHandler;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class Messageecoder implements Decoder.Text {
    private Gson gson= new Gson();

    public Object decode(String s) throws DecodeException {
        return null;
    }

    public boolean willDecode(String s) {
        return false;
    }

    public void init(EndpointConfig endpointConfig) {

    }

    public void destroy() {


    }
}
