<html>
<body>

<script type="text/javascript">
    var socket;

    function connect() {
        var s = document.getElementById("from").value;
//        socket = new WebSocket("ws://localhost:8080/websockets/chat/" + s);
        socket = new WebSocket("ws://192.168.1.155:8080/ChatAppBeta/chat/" + s);
        socket.onmessage = onMessage;
    }

    function onMessage(event) {
        alert(event.data)
    }

    function sendMessage(text) {
        var messageContent =document.getElementById('my').value
        var recipient = document.getElementById('sendto').value
        socket.send(JSON.stringify({
            to:recipient,
            message:"Sharon received the Message"+ messageContent
        }));
    }
    function onError(event) {
        alert(event.data)

    }
//
//   connect ()
</script>
Enter sender:
<input type="text" id="from">
<input type="button" value="connect" onclick="connect()"/>
Enter Message:
<input type="text" id="my">
<input type="button" value="Send" onclick="sendMessage()"/>
Enter Recepient:
<input type="text" id="sendto">
<input type="button" value="Send" onclick="sendMessage()"/>
</body>
</html>
