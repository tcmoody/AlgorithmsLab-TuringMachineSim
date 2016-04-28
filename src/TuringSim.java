
public class TuringSim {
	
	TuringTape t;
	//TuringSim constructor
	public TuringSim(){
	}
	
	//writes an input string to a TuringTape
	public void writeInput(char [] vals){
		t = new TuringTape();
		if(vals == null){
			throw new java.lang.NullPointerException();
		}
		
		for(int i=0; i<vals.length; i++){
			if(vals[i] != 'a' && vals[i] != 'b'){
				throw new java.lang.UnsupportedOperationException("You have to use a string of a's and b's only");	
			}else{
				if(vals[i] == 'a'){
					t.write(1);
					t.moveRight();
				}else if(vals[i] == 'b'){
					t.write(2);
					t.moveRight();
				}
			}
		}
		t.moveLeft();
		while(t.read() != 0){
			t.moveLeft();
		}
		t.moveRight();
	}
	
	//returns true if the TuringMachine accepts the given string
	public boolean accepts(){
		if(t == null){
			throw new java.lang.IllegalStateException();
		}
		int state=0;
		while(state>=0){
			switch(state){
				case 0:
					state=StateZero();
					break;
				case 1:
					state=StateOne();
					break;
				case 2:
					state=StateTwo();
					break;
				case 3:
					state=StateThree();
					break;
				case 4:
					state=StateFour();
					break;
				case 5:
					state=StateFive();
					break;
				case 6:
					state=StateSix();
					break;
				case 7:
					state=StateSeven();
					break;
				case 8:
					state=StateEight();
					break;
				case 9:
					state=StateNine();
					break;
				case 10:
					state=StateTen();
					break;
				case 11:
					state=StateEleven();
					break;
				case 12:
					state=StateTwelve();
					break;
				case 13:
					return true;
			}
		}
		return false;
	}
	

	//initial state
	private int StateZero(){
		if(t.read() == 1){
			t.write(3);
			t.moveRight();
			return 1;
		}else if(t.read() == 2){
			t.write(4);
			t.moveRight();
			return 1;
		}
		return -1;
	}
	
	//state one, shifts right until it hits a blank
	private int StateOne(){
		if(t.read() == 0){
			t.moveLeft();
			return 2;
		}else if(t.read() == 1 || t.read() == 2){
			t.moveRight();
			return 1;
		}
		return -1;
	}
	
	private int StateTwo(){
		if(t.read()==1){
			t.write(5);
			t.moveLeft();
			return 3;
		}else if(t.read()==2){
			t.write(6);
			t.moveLeft();
			return 3;
		}
		return -1;
	}
	
	private int StateThree(){
		if(t.read()==1 || t.read()==2){
			t.moveLeft();
			return 3;
		}else if(t.read()==3 || t.read()==4){
			t.moveRight();
			return 4;
		}
		return -1;
	}
	//checks to see if it should stay in overwrite loop, or if it
	//should move to loop to check to see if it accepts
	private int StateFour(){
		if(t.read()==1){
			t.write(3);
			t.moveRight();
			return 5;
		}else if(t.read()==2){
			t.write(4);
			t.moveRight();
			return 5;
		}else if(t.read()==5 || t.read()==6){
			t.moveRight();
			return 7;
		}
		return -1;
	}
	
	private int StateFive(){
		if(t.read()==1 || t.read()==2){
			t.moveRight();
			return 5;
		}else if(t.read()==5 || t.read()==6){
			t.moveLeft();
			return 6;
		}
		System.out.println("returning");
		return -1;
	}
	
	//loops around to continue checking/overwriting inputs
	private int StateSix(){
		if(t.read()==1){
			t.write(5);
			t.moveLeft();
			return 3;
		}else if(t.read()==2){
			t.write(6);
			t.moveLeft();
			return 3;
		}
		return -1;
	}

	//start of loop to check to see if sim accepts
	private int StateSeven(){
		if(t.read()==0){
			t.moveLeft();
			return 8;
		}
		if(t.read()==5 || t.read()==6){
			t.moveRight();
			return 7;
		}
		return -1;
	}
	
	private int StateEight(){
		if(t.read()==5){
			t.write(7);
			t.moveLeft();
			return 10;
		}else if(t.read()==6){
			t.write(7);
			t.moveLeft();
			return 9;
		}
		return -1;
	}
	
	private int StateNine(){
		if(t.read()==4){
			t.write(7);
			t.moveRight();
			return 11;
		}else if(t.read()==5 || t.read()==6 || t.read()==7){
			t.moveLeft();
			return 9;
		}
		return -1;
	}
	
	private int StateTen(){
		if(t.read()==3){
			t.write(7);
			t.moveRight();
			return 11;
		}else if(t.read()==5 || t.read()==6 || t.read()==7){
			t.moveLeft();
			return 10;
		}
		return -1;
	}
	
	private int StateEleven(){
		if(t.read()==5 || t.read()==6 || t.read()==7){
			t.moveRight();
			return 11;
		}else if(t.read()==0){
			t.moveLeft();
			return 12;
		}
		return -1;
	}
	
	//loops around to continue checking string to see if sim accepts
	//or returns true if we hit the 0 in front of string
	private int StateTwelve(){
		if(t.read()==5){
			t.write(7);
			t.moveLeft();
			return 10;
		}else if(t.read()==6){
			t.write(7);
			t.moveLeft();
			return 9;
		}else if(t.read()==7){
			t.moveLeft();
			return 12;
		}else if(t.read()==0){
			return 13;
		}
		return -1;
	}
}
