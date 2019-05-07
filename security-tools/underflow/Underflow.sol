pragma solidity ^0.5.0;

contract Underflow {

    mapping(address => uint) balances;

    function transfer(address _to, uint _value) public {
        uint result = balances[msg.sender] - _value;
        require(result >= 0);
        balances[msg.sender] -= _value;
        balances[_to] += _value;
    }
}
