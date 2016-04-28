
public class RunTimeAnalysis {
	
	public static void main(String[] args) {
		char [] val = new char[163072];
		//used for generating 'ab' repeating for runtime analysis
		val[0] = 'a';
		for(int i=1; i<val.length; i++){
			if(i % 2 == 0){
				val[i]='a';
			}else{
				val[i]='b';
			}
		}
		
		//used for generating 'aabb' repeating for runtime analysis
//		int counter=0;
//		for(int i=0; i<val.length; i++){
//			if(counter<2){
//				val[i]='a';
//				counter++;
//			}else if(counter>1 && counter<4){
//				val[i]='b';
//				counter++;
//			}else if(counter==4){
//				counter=0;
//				val[i]='a';
//				counter++;
//			}
//		}
		timerTest(val);
	}
	
	public static void timerTest(char[] vals){
		double timeAccepts, timeStatic;
		TuringSim mySim = new TuringSim();
		mySim.writeInput(vals);
		
		Stopwatch timerAccepts = new Stopwatch();
		mySim.accepts();
		timeAccepts=timerAccepts.elapsedTime();

		Stopwatch timerStatic = new Stopwatch();
		StaticTest(vals);
		timeStatic=timerStatic.elapsedTime();
		
		System.out.println("accepts:" + timeAccepts + " seconds\n" + "static:" + timeStatic + " seconds");
	}
	
	public static boolean StaticTest(char [] vals) {
		if (vals.length % 2 != 0) return false;
		
		int mid = vals.length/2;
		for(int i=0;i<mid;i++) {
			if (vals[i] != vals[mid+i]) return false;
		}
		return true;
	}	
}
