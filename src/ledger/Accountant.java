package ledger;

import exceptions.InvalidJournalEntryException;
import exceptions.InvalidSyntaxException;
import exceptions.UnequalBalanceException;

import java.util.ArrayList;

import static ledger.AccountManager.*;

public class Accountant {
	
	public void postEntry(String journalEntry) throws InvalidJournalEntryException {
		if(!(journalEntry.contains(", ")&&journalEntry.contains("; "))){
			throw new InvalidSyntaxException("Invalid syntax");
		}else{
			ArrayList<Account> liste = new ArrayList<>();
			ArrayList<Integer> betragList = new ArrayList<>();

			int j =0;
			int i =0;
			while(i<journalEntry.length()-1){
				if(journalEntry.charAt(i)==' '){
					liste.add(getAccount(journalEntry.substring(j,i)));
					j=i+1;
					i++;
				}else if(journalEntry.charAt(i)==';'||journalEntry.charAt(i)==','){
					betragList.add(Integer.parseInt(journalEntry.substring(j,i)));
					i+=2;
					j=i;
				}else{
					i++;
				}

			}
			betragList.add(Integer.parseInt(journalEntry.substring(j)));
			int sum=0;
			for(int k =0;i<(betragList.size()/2);i++){
				sum+= betragList.indexOf(k);
			}
			for(int l=(betragList.size()/2);l< betragList.size();l++){
				sum-= betragList.indexOf(l);
			}
			if(sum!=0){
				throw new UnequalBalanceException("Ammounts dont match");
			}else{
				for(Account accsd: liste){
					accsd.open();
				}
			}
			/* Understanding problems concerning how the accounts operate
			After i process the amounts for each account individually
			then i make sure i close all accounts with the close() function



*/
		}
		
		//check syntax and import 
		
		//Ensure that debit value equals credit value
		
		//Open Accounts
		
		//Post entries
		
		//Ensure that all accounts are closed
		
	}
}
