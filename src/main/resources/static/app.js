const stompClient = new StompJs.Client({
    brokerURL: 'ws://localhost:8080/gs-guide-websocket',
    onWebSocketError: (error) => {
        console.error('Error with websocket', error);
    },
    onStompError: (frame) => {
        console.error('Broker reported error: ' + frame.headers['message']);
        console.error('Additional details: ' + frame.body);
    }
});

stompClient.onConnect = (frame) => {
    setConnected(true);
    console.log('Connected: ' + frame);
    stompClient.subscribe('/topic/stackFrames', (stackFrameMessage) => {
        showStackFrame(JSON.parse(stackFrameMessage.body));
    });
};

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#stackFrameContainer").show();
    } else {
        $("#stackFrameContainer").hide();
    }
    $("#stackFrameBody").html("");
}

function connect() {
    stompClient.activate();
}

function disconnect() {
    stompClient.deactivate();
    setConnected(false);
    console.log("Disconnected");
}

function sendStackFrameRequest() {
    // This could be a request to the server to send a StackFrame
    stompClient.publish({
        destination: "/app/getStackFrame",
        body: JSON.stringify({}) // Adjust the body if necessary
    });
}

function showStackFrame(stackFrame) {
    // Clear the current content in the table
    $("#stackFrameBody").empty();

    // Display local variables
    var localVarsHtml = stackFrame.localVars.map(function (localVar) {
        return `<td>${localVar}</td>`;
    }).join('');

    // Display operand stack
    var operandStackHtml = stackFrame.operandStack.map(function (operand) {
        return `<td>${operand}</td>`;
    }).join('');

    // Display frame data
    var frameDataHtml = stackFrame.frameData.map(function (frameData) {
        return `<td>${frameData}</td>`;
    }).join('');

    // Append the row with the data
    $('#stackFrameBody').append(
        `<tr>
            ${localVarsHtml}
            ${operandStackHtml}
            ${frameDataHtml}
        </tr>`
    );
}

$(function () {
    $("form").on('submit', (e) => e.preventDefault());
    $("#connect").click(() => connect());
    $("#disconnect").click(() => disconnect());
    $("#send").click(() => sendStackFrameRequest());
});
