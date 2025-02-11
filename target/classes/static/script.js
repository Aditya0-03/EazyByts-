var socket = new SockJS('/chat');
var stompClient = Stomp.over(socket);

stompClient.connect({}, function(frame) {
    console.log("Connected: " + frame);
    stompClient.subscribe('/topic/messages', function(message) {
        var chatBox = document.getElementById("chat");
        var msg = JSON.parse(message.body);
        var listItem = document.createElement("li");
        listItem.innerText = msg.sender + ": " + msg.content;
        chatBox.appendChild(listItem);
    });
});

function sendMessage() {
    var msgInput = document.getElementById("message");
    var msg = { sender: "User", content: msgInput.value };
    stompClient.send("/app/send", {}, JSON.stringify(msg));
    msgInput.value = "";
}
