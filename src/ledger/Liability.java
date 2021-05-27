package ledger;

import exceptions.AccountClosedException;
import exceptions.AccountException;
import exceptions.AmountInsufficientException;

public class Liability extends Account {

	public Liability(String name) {
		super(name);
	}

	@Override
	public void credit(int value) throws AccountException {
		if ( !isOpen() ) {
			throw new AccountClosedException("Account is not open");
		} else if ( (this.value + value) < 0 ) {
			throw new AmountInsufficientException("Account amount insufficient");
		} else {
			this.delta += value;
		}
	}
	@Override
	public void debit(int value) throws AccountException{
		if(!isOpen()){
			throw new AccountClosedException("Account is not open");
		}else if((this.value-value)<0){
			throw new AmountInsufficientException("Account amount insufficient");
		}else{

			this.delta -= value;}

	}
}
