pragma solidity 0.5.0;

contract Bullsandcows {
    
  uint bulls = 0;
  uint cows = 0;

    mapping(uint => uint) positionsMap; 
    
    function setPosition(uint secret) public {
    uint cur_digit=0;
    uint count=4;
        for(uint i=1000;i>=10;i=i/10) {
            cur_digit=secret/i;
        positionsMap[cur_digit] = count;
        secret = secret % i;
        count--;
        }
    positionsMap[secret] = 1;
    }
    
    function checkGuess(uint guess) public {
       	bulls=0;
	cows=0;
	uint count=4;
        uint cur_digit=0;
        for(uint i=1000;i>=10;i=i/10) {
            cur_digit=guess/i;
            if(positionsMap[cur_digit] != 0) {
                if(positionsMap[cur_digit] == count) {
                    bulls++;
                }
                else {
                    cows++;
                }
            }
            guess=guess%i;
            count--;
            
            if (positionsMap[guess] != 0) {
                if(positionsMap[guess] ==1) {
                    bulls++;
                }
                else {
                    cows++;
                }
            }
        }
    }
        
        function getBulls() public view returns(uint) {
            return bulls;
        }
        
        function getCows() public view returns(uint) {
            return cows;
        }
    }
    
    
    