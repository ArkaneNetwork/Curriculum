pragma solidity >=0.4.21 <0.6.0;

contract Eurofins {

    event Message(
        address _from,
        string _message
    );

    string public currentMessage;

    function setMessage(string memory _message) public {
        currentMessage = _message;
        emit Message(msg.sender, _message);
    }
}