import com.google.gson.Gson;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@ServerEndpoint(value="/chat/{user}")

public class ChatEndServer  {
//store sesssion
  static Map<String, Session> map = new HashMap<String, Session>();

    @OnOpen
    public void onOpen(Session sesion, @PathParam("user") String s)  {
        //  Gets session and websocket connection when  is open
        try{
        System.out.println("Hey there i am connected ");
        map.put(s,sesion);
        sesion.getBasicRemote().sendText("Hey There");
            for(Map.Entry<String,Session> m1: map.entrySet()) {
                String usern = m1.getKey();
                Session ss = m1.getValue();
                System.out.println(usern+"\t"+ss.getId());


            }
            System.out.println("sent");
        }
            catch (IOException e){
            e.printStackTrace();
            }
    }
    @OnMessage
    public void onMessage(Session session, String  s ) {
        //handles the message
        try {
            Gson g = new Gson();
            Message m = g.fromJson(s, Message.class);
            session = map.get(m.getTo());
            session.getBasicRemote().sendText(m.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @OnClose
    public void onClose(Session session){
        //Handles when the application closes
        try{
            session.getBasicRemote().sendText("Connection closed");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    @OnError
    public void onError(Session session ,Throwable throwable){
        //Handles error
        try{
            session.getBasicRemote().sendText("Sorry an Error Occured");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void getNumberOfConnection() {
        for (Map.Entry m : map.entrySet()) {
            Session s = (Session) m.getValue();
            System.out.println(m.getKey() + " " + s.getId());
        }
    }
}

