class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    // This example we are substituting vowels
    // with unicode characters
    char[] sub = new char[5];
    sub[0] = 'a';
    sub[1] = 'e';
    sub[2] = 'i';
    sub[3] = 'o';
    sub[4] = 'u';

    char[] sub2 = new char[5];
    sub2[0] = '\u2663';  // Club
    sub2[1] = '\u2660';  // Heart
    sub2[2] = '\u2665';  // Spade
    sub2[3] = '\u2666';  // Diamond
    sub2[4] = '\u2836';  // Bralle symbol

    
    String file = Input.readFile("Original.txt");
    String encodedMsg = subEncryption(file,sub,sub2);
    Input.writeFile("Encode.txt",encodedMsg);

    String decodedMsg = subEncryption(encodedMsg, sub2, sub);
    Input.writeFile("Decode.txt", decodedMsg);
    
    
  }

  String subEncryption(String s, char[] sub, char[] sub2){
    String bld="";
    char ch ='\0';
    int index=0;
    for(int x=0; x<=s.length()-1; x++){
      ch=s.charAt(x);
      bld+=subst(ch, sub, sub2);
    }
    return bld;
  }
  
  char subst(char ch, char[] sub, char[] sub2){
    for(int x=0; x<sub.length; x++){
      if(sub[x]==ch){
        return sub2[x];
      }
    }
    return ch;
  }

  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

}