pragma solidity ^0.4.8;
contract Contract1 {
    mapping (address => uint) public balances;
    constructor() public payable {
        put();
    }
    function put() public payable {
        balances[msg.sender] = msg.value;
    }
    function get() public {
        if (!msg.sender.call.value(balances[msg.sender])()) {
            revert();
        }
        balances[msg.sender] = 0;
    }

    function() external{
        revert();
    }
}