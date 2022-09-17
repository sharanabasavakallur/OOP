import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Alphabet {
	public static void main(String args[])throws Exception{
	FileInputStream fin = null;
	FileOutputStream fout = null;
	
		fin = new FileInputStream("Alphabet.txt");
		fout = new FileOutputStream("Consonants.txt");
		int ch2;
		while((ch2=fin.read())!=-1){
			try{
			char ch=(char) ch2;
			if(!(ch=='a'||ch=='i'||ch=='e'||ch=='o'||ch=='u'
			||ch=='A'||ch=='I'||ch=='E'||ch=='O'||ch=='U'))
			fout.write(ch);
			else
			throw new VowelNotAllowedException();
			}catch(Exception e){
			System.out.println(e);
			}
		}
	}
}

class VowelNotAllowedException extends Exception {
	VowelNotAllowedException() {
	}
	public String toString() {
	return super.toString() + " : Vowels are Not Allowed";
	}
}