<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello WebSocket</title>
    <script src="${pageContext.request.contextPath}/resources/js/sockjs-0.3.4.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/stomp.js"></script>
    <script type="text/javascript">
        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        function connect() {
            var socket = new SockJS('${pageContext.request.contextPath}/routeMessage');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/chat/messages', function(greeting){
                    showGreeting(JSON.parse(greeting.body).content,JSON.parse(greeting.body).userId);
                });
            });
        }

        function disconnect() {
            stompClient.disconnect();
            setConnected(false);
            console.log("Disconnected");
        }

        function sendName() {
            var name = document.getElementById('name').value;
            var id=document.getElementById('id').value;
            stompClient.send("/routeMessage", {}, JSON.stringify({ 'content': name ,'userId':id}));
        }

        function showGreeting(message,id) {
            var response = document.getElementById('response');
            var p = document.createElement('p');
            p.style.wordWrap = 'break-word';
            var intId=parseInt(id);

            if(intId == ${currentId}){
                p.appendChild(document.createTextNode(message));
                response.appendChild(p);
            }

        }
    </script>
</head>
<body>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
    Javascript and reload this page!</h2></noscript>
<div>
    <div>
        <button id="connect" onclick="connect();">Connect</button>
        <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
    </div>
    <div id="conversationDiv">
        <c:if test="${currentId==1}">
            <input type="hidden" value="2" id="id">
        </c:if>
        <c:if test="${currentId==2}">
            <input type="hidden" value="1" id="id">
        </c:if>

        <label>What is your name?</label><input type="text" id="name" />
        <button id="sendName" onclick="sendName();">Send</button>
        <p id="response"></p>
    </div>
</div>
</body>
</html>
